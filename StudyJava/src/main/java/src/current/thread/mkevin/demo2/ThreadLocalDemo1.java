package src.current.thread.mkevin.demo2;

public class ThreadLocalDemo1 extends Thread{

    //多个线程之间读取副本, 父子线程之间复制传递
    public static InheritableThreadLocal<String> tl = new InheritableThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {

        tl.set("Kevin是一个自由讲师");

        Thread t0 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+ " get tl is : " + tl.get());
                tl.set("After Set The Value Change to " + Thread.currentThread().getName());
                System.out.println(Thread.currentThread().getName()+ " get tl is : " + tl.get());
            }
        });

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+ " get tl is : " + tl.get());
                tl.set("After Set The Value Change to " + Thread.currentThread().getName());
                System.out.println(Thread.currentThread().getName()+ " get tl is : " + tl.get());
            }
        });

        t0.start();

        Thread.sleep(1000);

        t1.start();

        System.out.println(Thread.currentThread().getName()+ " get tl is : " + tl.get());
    }

}


