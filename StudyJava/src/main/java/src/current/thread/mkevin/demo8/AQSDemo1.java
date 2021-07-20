package src.current.thread.mkevin.demo8;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  观察Condition的运行机制
 */
public class AQSDemo1 {

    static ReentrantLock rl = new ReentrantLock();
    static Condition condition = rl.newCondition();

    public static void main(String[] args) throws InterruptedException {

        new Runner().start();
        new Runner().start();
        new Runner().start();
    }

    static class Runner extends Thread{
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                rl.lock();
                System.out.println(Thread.currentThread().getName()+" before await..");
                //condition.signal();
                condition.await();
                System.out.println(Thread.currentThread().getName()+" after await..");
                rl.unlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}



