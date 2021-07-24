package current.thread.mkevin.demo9;

import java.util.concurrent.locks.StampedLock;

public class StampedLockDemo3 {

    public static void main(String[] args) throws InterruptedException {

        /*StampedLock sl = new StampedLock();
        //乐观读
        long stamp = sl.tryOptimisticRead();
        System.out.println(Thread.currentThread().getName()+" tryOptimisticRead stamp="+stamp);
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" run");
                long stamp131 = sl.writeLock();
                System.out.println(Thread.currentThread().getName()+" get write lock1,stamp="+stamp131);
                sl.unlockWrite(stamp131);
                System.out.println(Thread.currentThread().getName()+" unlock write lock1,stamp="+stamp131);
            }
        }).start();
        Thread.sleep(3000);
        //验证是否发生过变化
        boolean validate = sl.validate(stamp);
        System.out.println(Thread.currentThread().getName()+" tryOptimisticRead validate="+validate);
        stamp = sl.tryOptimisticRead();
        System.out.println(Thread.currentThread().getName()+" tryOptimisticRead stamp="+stamp);
        validate = sl.validate(stamp);*/


        StampedLock sl = new StampedLock();
        long stamp1 = sl.writeLock();
        System.out.println(Thread.currentThread().getName()+" writeLock stamp="+stamp1);
        //乐观读
        long stamp = sl.tryOptimisticRead();
        System.out.println(Thread.currentThread().getName()+" tryOptimisticRead stamp="+stamp);
        System.out.println(sl.validate(stamp));

        if(sl.validate(stamp)){

        }
    }

}
