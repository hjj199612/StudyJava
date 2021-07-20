package src.current.thread.mkevin.demo1;

public class WaitDemo1 {

    public static void main(String[] args) {

        final Object lock = new Object();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    System.out.println(Thread.currentThread().getName()+" get Lock, waiting");
                    try {
                        //Kevin提醒：如果达到2s还没有得到notify或者interrupt,则继续执行
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+" release Lock,run over");
                }
            }
        });

        //t1.interrupt();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    System.out.println(Thread.currentThread().getName()+" get Lock, t1.interrupt");
                    //Kevin提醒：中断t1线程
                    t1.interrupt();
                    System.out.println(Thread.currentThread().getName()+" release Lock,run over");
                }
            }
        });

        t1.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("final:"+t1.getName()+" and " + t2.getName() + " run over!");
        System.out.println("t1's state:"+t1.getState());
        System.out.println("t2's state:"+t2.getState());
    }

}
