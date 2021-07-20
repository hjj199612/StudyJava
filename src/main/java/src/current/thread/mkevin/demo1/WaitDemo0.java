package src.current.thread.mkevin.demo1;

public class WaitDemo0 {

    public static void main(String[] args) {

        final Object lock = new Object();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    System.out.println(Thread.currentThread().getName()+" get Lock, waiting 2000 million");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+" release Lock,run over");
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //Kevin提醒：修改这个数值的大小,来观察t1线程wailt(timeout)的效果
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock){
                    System.out.println(Thread.currentThread().getName()+" get Lock, notify");
                    lock.notify();
                    System.out.println(Thread.currentThread().getName()+" release Lock,run over");
                }
            }
        });

        t1.start();
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
