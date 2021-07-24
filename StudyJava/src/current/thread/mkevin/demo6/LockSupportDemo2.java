package current.thread.mkevin.demo6;

import java.util.concurrent.locks.LockSupport;

/**
 * 1.如果某个线程没有调用park方法，而是先调用了unpark方法，则再调用park方法时不会阻塞。
 * 2.在park之前连续调用多次unpark，也只会影响第一次park的调用
 */
public class LockSupportDemo2 {

    public static void main(String[] args) throws InterruptedException {

        System.out.println(Thread.currentThread().getName()+" start run");

        LockSupport.unpark(Thread.currentThread());
        LockSupport.unpark(Thread.currentThread());
        LockSupport.unpark(Thread.currentThread());
        LockSupport.unpark(Thread.currentThread());
        LockSupport.park();
        System.out.println(Thread.currentThread().getName()+" park1 already run");
        LockSupport.park();
        System.out.println(Thread.currentThread().getName()+" park2 already run");
        LockSupport.park();
        System.out.println(Thread.currentThread().getName()+" park3 already run");
        LockSupport.park();
        System.out.println(Thread.currentThread().getName()+" park4 already run");
        System.out.println(Thread.currentThread().getName()+" stop run");
    }

}
