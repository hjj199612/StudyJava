package current.thread.mkevin.demo3;

import sun.misc.Unsafe;

/**
 * Unsafe类的安全限制
 */
public class UnsafeDemo0 {

    private int age;

    public int getAge() {
        return age;
    }

    public static void main(String[] args) {
        UnsafeDemo0 demo0 = new UnsafeDemo0();

        // 获取Unsafe类实例
        Unsafe unsafe = Unsafe.getUnsafe();
        try {
            //获取age属性的内存偏移地址
            long ageOffset = unsafe.objectFieldOffset(UnsafeDemo0.class.getDeclaredField("age"));
            //设置age的值为11
            unsafe.putInt(demo0,ageOffset,11);
            //输出结果
            System.out.println(demo0.getAge());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
