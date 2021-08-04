package current.lock;// 必须定义 `ShowMeBug` 入口类和 `public static void main(String[] args)` 入口方法

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

//实现一个类 支持100个线程同时向一个银行账户中存入2元钱
public class ReentrantLockDemo extends Thread {

    /**
     * 存款
     *
     * @param money 存入金额
     */

    static ReentrantLock lock = new ReentrantLock();
    static double count = 0;

    public static void main(String[] args) {
        ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(100);
        ThreadPoolExecutor myPool = new ThreadPoolExecutor(100, 100, 1, TimeUnit.DAYS, queue);
        for (int i = 0; i < 100; i++) {
            queue.add(new ReentrantLockDemo());
        }
        myPool.execute(new Thread());
        myPool.shutdown();
        while (!myPool.isTerminated()) {
        }
        System.out.println(count);
    }


    public void deposit(double money) {
        lock.lock();
        count += money;
        lock.unlock();
    }


    @Override
    public void run() {
        deposit(2);
    }
}