package src.current.thread.mkevin.demo4;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Random类使用，性能低
 */
public class RandomDemo0 {

    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();

        Random random = new Random();
        CountDownLatch cd = new CountDownLatch(100);
        CyclicBarrier barrier = new CyclicBarrier(100);
        ExecutorService executor = Executors.newFixedThreadPool(100);
        for(int i=0;i<100;i++){
            executor.submit(new RandomDemo0Runner(barrier,"thread"+i,random,cd));
        }

        cd.await();

        long use = System.currentTimeMillis()-start;

        System.out.println("main is over.."+use);

        executor.shutdown();
    }

}

class RandomDemo0Runner implements Runnable {

    private CyclicBarrier barrier;

    private String name;

    private Random random;

    private CountDownLatch cd;

    public RandomDemo0Runner(CyclicBarrier barrier, String name,Random random, CountDownLatch cd) {
        super();
        this.barrier = barrier;
        this.name = name;
        this.random = random;
        this.cd = cd;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " 准备好了...");
            barrier.await();
            for(int j=0;j<10000;j++) {
                //KEIVN: 高并发CAS锁竞争
                this.random.nextInt(50);
                //System.out.println(Thread.currentThread().getName() + ">" + this.random.nextInt(50));
                //KEVIN: 产生大量对象
                //System.out.println(Thread.currentThread().getName() + ">" + new Random().nextInt(50));
            }
            cd.countDown();
        } catch (InterruptedException e) {
            System.out.println(name + " 中断异常！");
        } catch (BrokenBarrierException e) {
            System.out.println(name + " Barrier损坏异常！");
        }
    }
}
