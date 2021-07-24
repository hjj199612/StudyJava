package current.thread.mkevin.demo2;

public class ThreadLocalDemo0 {

    public static ThreadLocal<String> tl = new ThreadLocal<>();

    public static void main(String[] args) {

        tl.set("Kevin是一个自由讲师");

        Thread t0 = new Thread(new Runnable() {
            @Override
            public void run() {
                //KEVIN: 子线程无法获取父线程ThreadLocal的值,因为他们是两个独立的用户线程，都使用各自的副本
                System.out.println(Thread.currentThread().getName()+ " get tl is : " + tl.get());
            }
        });

        t0.start();

        //KEVIN: 主线程可以获取到
        System.out.println(Thread.currentThread().getName()+ " get tl is : " + tl.get());
    }

}
