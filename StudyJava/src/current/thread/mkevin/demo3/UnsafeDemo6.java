package current.thread.mkevin.demo3;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * volatile操作
 */
public class UnsafeDemo6 {

    private volatile  int age;

    public int getAge() {
        return age;
    }

    public static void main(String[] args) {
        UnsafeDemo6 demo0 = new UnsafeDemo6();
        try {
            //通过反射获取Unsafe的静态成员变量theUnsafe
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            //设置此字段为可存取
            field.setAccessible(true);
            //获取变量的值,强转为Unsafe类对象
            Unsafe unsafe = (Unsafe) field.get(null);

            //获取age属性的内存偏移地址
            long ageOffset = unsafe.objectFieldOffset(UnsafeDemo1.class.getDeclaredField("age"));

            //设置volatile age的值为11
            unsafe.putIntVolatile(demo0,ageOffset,11);
            System.out.println("KEVIN-1-putIntVolatile>>"+demo0.getAge());

            //获取volatile age的值
            int age = unsafe.getIntVolatile(demo0,ageOffset);
            System.out.println("KEVIN-1-getIntVolatile>>"+age);

            //验证CAS方法
            boolean result = unsafe.compareAndSwapInt(demo0,ageOffset,10,50);
            System.out.println("KEVIN-2-compareAndSwapInt>>"+demo0.getAge()+","+result);
            //验证CAS方法
            result = unsafe.compareAndSwapInt(demo0,ageOffset,11,100);
            System.out.println("KEVIN-3-compareAndSwapInt>>"+demo0.getAge()+","+result);

            //获取并设置
            age = unsafe.getAndSetInt(demo0,ageOffset,99);
            System.out.println("KEVIN-4-getAndSetInt>>"+age+","+demo0.getAge());

            //获取并增加
            age = unsafe.getAndAddInt(demo0,ageOffset,100);
            System.out.println("KEVIN-5-getAndAddInt>>"+age+","+demo0.getAge());

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
