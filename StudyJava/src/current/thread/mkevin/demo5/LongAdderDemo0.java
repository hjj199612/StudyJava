package current.thread.mkevin.demo5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicLong;

public class LongAdderDemo0 {

    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(100);
        AtomicLong al = new AtomicLong();
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        barrier.await();
                        for(int i=0;i<10000;i++) {
                            al.incrementAndGet();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
            list.add(t);
        }

        long start = System.currentTimeMillis();
        for (Thread th : list) {
            th.start();
        }
        for (Thread th : list) {
            th.join();
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时:" + (end - start) + "ms, KEVIN-sum:" + al.get());
    }

}
