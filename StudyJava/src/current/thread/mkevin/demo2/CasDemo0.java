package current.thread.mkevin.demo2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * AtomicStampedReference 来解决CAS的ABA问题
 */
public class CasDemo0 {

    private static AtomicStampedReference<Integer> atomic = new AtomicStampedReference<>(100, 0);

    public static void main(String[] args) throws InterruptedException {
        Thread t0 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    boolean sucess = atomic.compareAndSet(100, 101, atomic.getStamp(), atomic.getStamp() + 1);
                    System.out.println(Thread.currentThread().getName()+" set 100>101 : "+sucess);
                    sucess = atomic.compareAndSet(101, 100, atomic.getStamp(), atomic.getStamp() + 1);
                    System.out.println(Thread.currentThread().getName()+" set 101>100 : "+sucess);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t0.start();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int stamp = atomic.getStamp();
                    System.out.println(Thread.currentThread().getName()+" 修改之前 : " +stamp);
                    TimeUnit.SECONDS.sleep(2);
                    int stamp1 = atomic.getStamp();
                    System.out.println(Thread.currentThread().getName()+" 等待两秒之后,版本被t0线程修改为 : " +stamp1);

                    //Kevin提醒: 一下两次修改都不会成功,因为版本不符,虽然期待值是相同的,因此解决了ABA问题
                    boolean success = atomic.compareAndSet(100, 101, stamp, stamp + 1);
                    System.out.println(Thread.currentThread().getName()+" set 100>101 使用错误的时间戳: " + success);
                    success = atomic.compareAndSet(101,100,stamp,stamp+1);
                    System.out.println(Thread.currentThread().getName()+" set 101>100 使用错误的时间戳: " + success);

                    //Kevin提醒：以下修改是成功的,因为使用了正确的版本号,正确的期待值
                    success = atomic.compareAndSet(100,101,stamp1,stamp1+1);
                    System.out.println(Thread.currentThread().getName()+" set 100>101 使用正确的时间戳: " + success);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();

        t0.join();
        t1.join();

        System.out.println("main is over");
    }
}
