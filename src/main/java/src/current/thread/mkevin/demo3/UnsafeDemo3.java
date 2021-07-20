package src.current.thread.mkevin.demo3;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * 数组内元素的设置
 */
public class UnsafeDemo3 {

    private long[] salary = {0,1,2,3,4};

    public long[] getSalary() {
        return salary;
    }

    public static void main(String[] args) {
        UnsafeDemo3 demo0 = new UnsafeDemo3();
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
            long salaryOffset = unsafe.objectFieldOffset(UnsafeDemo3.class.getDeclaredField("salary"));
            //设置数组中第1个元素的值
            unsafe.putLong(demo0.getSalary(),(long)offset+scale*0,9);
            System.out.println("KEVIN-3-put0>>"+ Arrays.toString(demo0.getSalary()));
            //设置数组中第2个元素的值
            unsafe.putLong(demo0.getSalary(),(long)offset+scale*1,9);
            System.out.println("KEVIN-3-put1>>"+ Arrays.toString(demo0.getSalary()));
            unsafe.putLong(demo0.getSalary(),(long)offset+scale*2,9);
            System.out.println("KEVIN-3-put2>>"+ Arrays.toString(demo0.getSalary()));
            unsafe.putLong(demo0.getSalary(),(long)offset+scale*3,9);
            System.out.println("KEVIN-3-put3>>"+ Arrays.toString(demo0.getSalary()));
            unsafe.putLong(demo0.getSalary(),(long)offset+scale*4,9);
            System.out.println("KEVIN-3-put4>>"+ Arrays.toString(demo0.getSalary()));
            //设置第6个元素,不会自动扩容
            unsafe.putLong(demo0.getSalary(),(long)offset+scale*5,99);
            System.out.println("KEVIN-3-put5>>"+ Arrays.toString(demo0.getSalary()));

            //操作局部数组变量
            long[] array = new long[]{1,1,1,1};
            unsafe.putLong(array,(long)offset+scale*0,9);
            System.out.println("KEVIN-4-put0>>"+ Arrays.toString(array));
            unsafe.putLong(array,(long)offset+scale*1,9);
            System.out.println("KEVIN-4-put1>>"+ Arrays.toString(array));
            unsafe.putLong(array,(long)offset+scale*2,9);
            System.out.println("KEVIN-4-put2>>"+ Arrays.toString(array));

            //对数组的某个元素采用cas方法
            boolean result = unsafe.compareAndSwapLong(array,(long)offset+scale*3,9,10);
            System.out.println("KEVIN-5-cas1>>"+ Arrays.toString(array)+","+result);
            result = unsafe.compareAndSwapLong(array,(long)offset+scale*3,1,10);
            System.out.println("KEVIN-5-cas2>>"+ Arrays.toString(array)+","+result);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
