package current.thread.mkevin.demo6;

import java.util.concurrent.locks.LockSupport;

/**
 * park(blocker) 可传入阻塞者对象，一般传入this,官方推荐. 可以在线程堆栈中看到
 *
 */
public class LockSupportDemo3 {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" start run");
                //KEVIN知识点：对比是否传入blocker有哪些区别
                //LockSupport.park();
                LockSupport.park(this);
                System.out.println(Thread.currentThread().getName()+" stop run");
            }
        });
        t.start();
        t.join();
        System.out.println(Thread.currentThread().getName()+" stop run");
    }

}
