package current.thread.mkevin.demo9;

import src.current.thread.mkevin.entity.P;

import java.util.concurrent.locks.StampedLock;

public class StampedLockDemo1 {

    public static void main(String[] args) {

        /*P.o("StampedLock的WriteLock正常使用");
        //创建StampedLock对象
        StampedLock sl = new StampedLock();
        //获取读锁，并且返回stamp
        long stamp = sl.writeLock();
        System.out.println("get write lock,stamp="+stamp);
        //使用完毕，释放锁，但是要传入对应的stamp
        sl.unlockWrite(stamp);
        //再次获取写锁
        stamp = sl.writeLock();
        System.out.println("get write lock,stamp="+stamp);
        //释放写锁
        sl.unlockWrite(stamp);*/

        /*P.o("StampedLock的WriteLock非正常使用:非重入锁");
        StampedLock sl = new StampedLock();
        long stamp = sl.writeLock();
        System.out.println("get write lock,stamp="+stamp);
        stamp = sl.writeLock();
        System.out.println("get write lock,stamp="+stamp);
        sl.unlockWrite(stamp);*/

        /*P.o("ReentrantLock:重入锁对比");
        ReentrantLock rl = new ReentrantLock();
        rl.lock();
        System.out.println("get ReentrantLock lock1");
        rl.lock();
        System.out.println("get ReentrantLock lock2");
        rl.unlock();*/


        /*P.o("ReentrantReadWriteLock:重入锁对比");
        ReentrantReadWriteLock rrw = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.WriteLock writeLock = rrw.writeLock();
        writeLock.lock();
        System.out.println("get ReentrantReadWriteLock.WriteLock lock1");
        writeLock.lock();
        System.out.println("get ReentrantReadWriteLock.WriteLock lock2");
        writeLock.unlock();*/

        P.o("StampedLock.tryWriteLock:尝试获取，如果能获取则获取锁，获取不到不阻塞");
        StampedLock sl1 = new StampedLock();
        long stamp1 = sl1.tryWriteLock();
        System.out.println("get StampedLock.tryWriteLock lock1,stamp="+stamp1);
        long stamp2 = sl1.tryWriteLock();
        System.out.println("can not get StampedLock.tryWriteLock lock1,stamp="+stamp2);
        long stamp3 = sl1.writeLock();
        System.out.println("can not get StampedLock.writeLock lock2,stamp="+stamp3);
        sl1.unlockWrite(stamp1);
    }

}
