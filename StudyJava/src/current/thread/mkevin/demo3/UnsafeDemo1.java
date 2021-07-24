package current.thread.mkevin.demo3;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 突破Unsafe类的安全限制
 */
public class UnsafeDemo1 {

    private int age;

    public int getAge() {
        return age;
    }

    public static void main(String[] args) {
        UnsafeDemo1 demo0 = new UnsafeDemo1();
        try {
            //通过反射获取Unsafe的静态成员变量theUnsafe
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            //设置此字段为可存取
            field.setAccessible(true);
            //获取变量的值,强转为Unsafe类对象
            Unsafe unsafe = (Unsafe) field.get(null);

            //获取age属性的内存偏移地址
            long ageOffset = unsafe.objectFieldOffset(UnsafeDemo1.class.getDeclaredField("age"));
            //设置age的值为11
            unsafe.putInt(demo0,ageOffset,11);
            System.out.println("KEVIN-1>>"+demo0.getAge());
            //获取age
            int age = unsafe.getInt(demo0,ageOffset);
            System.out.println("KEVIN-1-getInt>>"+age);
            //验证CAS方法
            boolean result = unsafe.compareAndSwapInt(demo0,ageOffset,10,50);
            System.out.println("KEVIN-2>>"+demo0.getAge()+","+result);
            //验证CAS方法
            result = unsafe.compareAndSwapInt(demo0,ageOffset,11,100);
            System.out.println("KEVIN-3>>"+demo0.getAge()+","+result);
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
