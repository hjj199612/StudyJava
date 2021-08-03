package current.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author hjj199612
 * @date 2021/8/3 10:29 下午
 * @description 读写锁学习
 */
public class ReentrantReadWriteLockDemo {

    static ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);

    public static void main(String[] args) throws InterruptedException {

        MyThreadRead thread0 = new MyThreadRead();
        MyThreadRead thread1 = new MyThreadRead();
        thread0.start();
        thread1.start();//读锁之间不冲突 读锁可以加读锁
        Thread.sleep(1000 * 5);
        System.out.println("-----------------");

        MyThreadWrite thread2 = new MyThreadWrite();
        MyThreadWrite thread3 = new MyThreadWrite();
        thread2.start();
        thread3.start();//写锁之间有冲突 加了写锁无法再加写锁
        Thread.sleep(1000 * 5);
        System.out.println("-----------------");

        MyThreadRead thread4 = new MyThreadRead();
        MyThreadWrite thread5 = new MyThreadWrite();
        thread4.start();
        thread5.start();//读锁和写锁之间有冲突 加了读锁不能加写锁
        Thread.sleep(1000 * 5);
        System.out.println("-----------------");

        MyThreadWrite thread6 = new MyThreadWrite();
        MyThreadRead thread7 = new MyThreadRead();
        thread6.start();
        thread7.start();//读锁和写锁之间有冲突 加了写锁不能加读锁
        Thread.sleep(1000 * 5);
        System.out.println("-----------------");

        MyThreadWriteRead thread8 = new MyThreadWriteRead();
        thread8.start();//对于当前线程 加了写锁也可以加读锁 但是加了读锁不能加写锁


        MyThreadReadWrite thread9 = new MyThreadReadWrite();
        thread9.start();//对于当前线程 加了写锁也可以加读锁 但是加了读锁不能加写锁
    }

    private static class MyThreadRead extends Thread {
        @Override
        public void run() {
            lock.readLock().lock();
            try {
                System.out.println(Thread.currentThread().getName() + "加了读锁！");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.readLock().unlock();
            System.out.println(Thread.currentThread().getName() + "释放了读锁！");
        }
    }

    private static class MyThreadWrite extends Thread {
        @Override
        public void run() {
            lock.writeLock().lock();
            try {
                System.out.println(Thread.currentThread().getName() + "加了写锁！");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.writeLock().unlock();
            System.out.println(Thread.currentThread().getName() + "释放了写锁！");
        }
    }

    private static class MyThreadWriteRead extends Thread {
        @Override
        public void run() {
            lock.writeLock().lock();
            lock.readLock().lock();
            try {
                System.out.println(Thread.currentThread().getName() + "先加写锁，再读锁！");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.readLock().unlock();
            lock.writeLock().unlock();
            System.out.println(Thread.currentThread().getName() + "释放了读锁和写锁！");
        }
    }

    private static class MyThreadReadWrite extends Thread {
        @Override
        public void run() {
            lock.readLock().lock();
            lock.writeLock().lock();
            try {
                System.out.println(Thread.currentThread().getName() + "先加了读锁再加写锁写锁！");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.readLock().unlock();
            lock.writeLock().unlock();
            System.out.println(Thread.currentThread().getName() + "释放了读锁和写锁！");
        }
    }


}