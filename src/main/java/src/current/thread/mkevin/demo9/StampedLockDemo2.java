package src.current.thread.mkevin.demo9;

import src.current.thread.mkevin.entity.P;

import java.util.concurrent.locks.StampedLock;

public class StampedLockDemo2 {

    public static void main(String[] args) throws InterruptedException {

        /*P.o("StampedLock.readLock正常使用：注意每次获得的写锁stamp不同,必须所有的读锁都释放才可以获得写锁");
        StampedLock sl = new StampedLock();
        long stamp1 = sl.readLock();
        System.out.println("get read lock1,stamp="+stamp1);
        long stamp2 = sl.readLock();
        System.out.println("get read lock2,stamp="+stamp2);
        sl.unlockRead(stamp1);
        sl.unlockRead(stamp2);
        long stamp3 = sl.writeLock();
        System.out.println("get write lock,stamp="+stamp3);*/

        /*P.o("StampedLock.readLock非正常使用:存在读锁未释放,无法获得写锁");
        StampedLock sl1 = new StampedLock();
        long stamp11 = sl1.readLock();
        System.out.println("get read lock1,stamp="+stamp11);
        long stamp21 = sl1.readLock();
        System.out.println("get read lock2,stamp="+stamp21);
        sl1.unlockRead(stamp11);
        sl1.unlockRead(stamp21);
        long stamp31 = sl1.writeLock();
        System.out.println("get write lock,stamp="+stamp31);*/

        /*P.o("StampedLock.readLock正常使用:获取读锁->释放->获取写锁");
        StampedLock sl2 = new StampedLock();
        long stamp12 = sl2.readLock();
        System.out.println(Thread.currentThread().getName()+" get read lock1,stamp="+stamp12);
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" run");
                long stamp121 = sl2.writeLock();
                System.out.println(Thread.currentThread().getName()+" get write lock1,stamp="+stamp121);
            }
        }).start();

        Thread.sleep(3000);
        System.out.println(Thread.currentThread().getName()+" get unlock read lock1,stamp="+stamp12);
        sl2.unlockRead(stamp12);*/

        P.o("StampedLock.readLock正常使用:获取写锁->释放->获取读锁");
        StampedLock sl3 = new StampedLock();
        long stamp13 = sl3.writeLock();
        System.out.println(Thread.currentThread().getName()+" get write lock1,stamp="+stamp13);
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" run");
                long stamp131 = sl3.readLock();
                System.out.println(Thread.currentThread().getName()+" get read lock1,stamp="+stamp131);
            }
        }).start();
        Thread.sleep(3000);
        System.out.println(Thread.currentThread().getName()+" get unlock write lock1,stamp="+stamp13);
        sl3.unlockWrite(stamp13);

    }

}
