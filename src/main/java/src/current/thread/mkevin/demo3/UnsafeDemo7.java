package src.current.thread.mkevin.demo3;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * park 和 unpuark
 */
public class UnsafeDemo7 {

    private volatile  int age;

    public int getAge() {
        return age;
    }

    public static void main(String[] args) {
        UnsafeDemo7 demo0 = new UnsafeDemo7();
        try {
            //通过反射获取Unsafe的静态成员变量theUnsafe
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            //设置此字段为可存取
            field.setAccessible(true);
            //获取变量的值,强转为Unsafe类对象
            Unsafe unsafe = (Unsafe) field.get(null);

            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"-start" );
                    //KEVIN:非绝对时间为纳秒
                    //unsafe.park(false,2000*1000000);
                    //KEVIN：绝对时间为毫秒
                    unsafe.park(true,System.currentTimeMillis()+2000);
                    //KEVIN:配合interrupte查看效果
                    if(Thread.currentThread().isInterrupted()){
                        System.out.println(Thread.currentThread().getName()+"-interrupte" );
                    }
                    System.out.println(Thread.currentThread().getName()+"-end" );
                }
            });

            t.start();

            System.out.println(Thread.currentThread().getName()+"-run" );

            //KEVIN：打开关闭查看效果
            //unsafe.unpark(t);
            //KEVIN：打开关闭查看效果
            t.interrupt();


        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
