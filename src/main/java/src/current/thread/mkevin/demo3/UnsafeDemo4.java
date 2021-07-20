package src.current.thread.mkevin.demo3;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 静态成员操作
 */
public class UnsafeDemo4 {

    public static int state = 0;

    public static void main(String[] args) {
        UnsafeDemo4 demo0 = new UnsafeDemo4();
        try {
            //通过反射获取Unsafe的静态成员变量theUnsafe
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            //设置此字段为可存取
            field.setAccessible(true);
            //获取变量的值,强转为Unsafe类对象
            Unsafe unsafe = (Unsafe) field.get(null);

            //获取静态字段的便宜地址
            long stateOffset = unsafe.staticFieldOffset(UnsafeDemo4.class.getDeclaredField("state"));

            //获取静态字段的值
            int state1 = unsafe.getInt(demo0,stateOffset);
            System.out.println("Kevin-1-getInt1>"+state1);

            //获取静态字段的值
            state1 = unsafe.getInt(UnsafeDemo4.class,stateOffset);
            System.out.println("Kevin-1-getInt2>"+state1);
            //获取并且增加静态字段的值
            int state2 = unsafe.getAndAddInt(UnsafeDemo4.class,stateOffset,11);
            System.out.println("Kevin-2-getAndAddInt>"+state2);
            //再次获取静态字段的值
            int state3 = unsafe.getInt(UnsafeDemo4.class,stateOffset);
            System.out.println("Kevin-3-getInt>"+state3);
            //CAS操作
            boolean result = unsafe.compareAndSwapInt(UnsafeDemo4.class,stateOffset,11,12);
            System.out.println("Kevin-4-getInt>"+UnsafeDemo4.state+","+result);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
