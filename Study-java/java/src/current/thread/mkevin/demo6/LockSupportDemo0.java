package src.current.thread.mkevin.demo6;

import java.util.concurrent.locks.LockSupport;

/**
 * LockSupport的基本用法
 */
public class LockSupportDemo0 {

    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" start run");
                //KEVIN知识点1: park()与unpark()需要成对儿使用
                //LockSupport.park();
                //KEVIN知识点2：parkUntil(deadline) 可以单独使用
                //LockSupport.parkUntil(System.currentTimeMillis()+2000);
                //KEVIN知识点3：parkNanos(nanos) 可以单独使用
                LockSupport.parkNanos(1000000000);
                System.out.println(Thread.currentThread().getName()+" stop run");
            }
        });

        t.start();

        //Thread.sleep(2000);

        //KEVIN知识点1: park()与unpark()需要成对儿使用
        //LockSupport.unpark(t);

        t.join();
        System.out.println(Thread.currentThread().getName()+" stop run");
    }

}
