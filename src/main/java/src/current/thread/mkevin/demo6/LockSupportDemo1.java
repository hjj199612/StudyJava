package src.current.thread.mkevin.demo6;

import java.util.concurrent.locks.LockSupport;

/**
 * 调用线程的interrupt也会导致park被中断，但是差别是它不抛出InterruptedException
 */
public class LockSupportDemo1 {

    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" start run");
                //KEVIN知识点1:调用线程的interrupt也会导致park被中断，但是差别是它不抛出InterruptedException
                LockSupport.park();
                if(Thread.currentThread().isInterrupted()){
                    //KEVIN知识点1: 通常通过判断来弥补这个问题，当发生中断时执行自定义操作
                    System.out.println(Thread.currentThread().getName()+" is interrupted, so do something");
                    LockSupport.park();
                    System.out.println(Thread.currentThread().getName()+" repark");
                    LockSupport.park();
                    System.out.println(Thread.currentThread().getName()+" repark");
                }
                System.out.println(Thread.currentThread().getName()+" stop run");
            }
        });
        t.start();
        Thread.sleep(2000);
        //KEVIN知识点1:调用线程的interrupt也会导致park被中断，但是差别是它不抛出InterruptedException
        t.interrupt();
        t.join();
        System.out.println(Thread.currentThread().getName()+" stop run");
    }

}
