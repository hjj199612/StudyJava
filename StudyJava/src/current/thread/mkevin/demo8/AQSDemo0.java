package current.thread.mkevin.demo8;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 通过跟踪ReentrantLock的运行， 理解AQS的原理和作用
 */
public class AQSDemo0 {

    public static void main(String[] args) throws InterruptedException {

        ReentrantLock rl = new ReentrantLock();
        System.out.println(Thread.currentThread().getName()+" start rl.lock");
        rl.lock();
        rl.lock();

        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" start rl.lock");
                System.out.println("start re lock2");
                rl.lock();
            }
        });

        th.start();
        th.join();
        rl.unlock();
        System.out.println(Thread.currentThread().getName()+" start rl.unlock");
        System.out.println("main is over");
    }

}
