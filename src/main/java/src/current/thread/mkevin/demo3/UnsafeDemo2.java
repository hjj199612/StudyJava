package src.current.thread.mkevin.demo3;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * 数组对象的设置
 */
public class UnsafeDemo2 {

    private long[] salary = {0,1,2,3,4};

    public long[] getSalary() {
        return salary;
    }

    public static void main(String[] args) {
        UnsafeDemo2 demo0 = new UnsafeDemo2();
        try {
            //通过反射获取Unsafe的静态成员变量theUnsafe
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            //设置此字段为可存取
            field.setAccessible(true);
            //获取变量的值,强转为Unsafe类对象
            Unsafe unsafe = (Unsafe) field.get(null);

            int offset = unsafe.arrayBaseOffset(long[].class);
            int scale = unsafe.arrayIndexScale(long[].class);

            System.out.println("KEVIN-1-offset>>"+offset);
            System.out.println("KEVIN-2-scale>>"+scale);

            //获取salary字段偏移地址
            long salaryOffset = unsafe.objectFieldOffset(UnsafeDemo2.class.getDeclaredField("salary"));
            //设置数组
            long[] local = new long[]{3,4,5,6};
            unsafe.putObject(demo0,salaryOffset,local);
            System.out.println("KEVIN-3-put>>"+ Arrays.toString(demo0.getSalary()));
            //CAS成功
            boolean result = unsafe.compareAndSwapObject(demo0,salaryOffset,local,new long[]{9,8,7,6});
            System.out.println("KEVIN-4-cas>>"+ Arrays.toString(demo0.getSalary())+","+result);
            //CAS失败
            result = unsafe.compareAndSwapObject(demo0,salaryOffset,new long[]{9,8,7,6},new long[]{3,3,3,3});
            System.out.println("KEVIN-4-cas>>"+ Arrays.toString(demo0.getSalary())+","+result);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
