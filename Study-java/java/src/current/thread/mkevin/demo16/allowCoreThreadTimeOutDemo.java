package src.current.thread.mkevin.demo16;

import src.current.thread.mkevin.entity.P;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class allowCoreThreadTimeOutDemo {
    public static void main(String[] args) throws InterruptedException {
        /**
         * 设置控制核心线程是否可能超时的策略，如果在保持活动时间内没有任务到达，则该策略将在新任务到达时根据需要被替换。
         * 如果为false，则不会由于缺少传入任务而终止核心线程。
         * 如果为true，则应用于非核心线程的相同保持活动策略也适用于核心线程。
         * 为避免连续更换线程，设置为true时保持活动时间必须大于零。
         * 通常应该在池被激活之前调用此方法。
         */

        /*ThreadPoolExecutor pool = new ThreadPoolExecutor(4, 5,
                5, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        P.l("是否允许核心线程超时:"+pool.allowsCoreThreadTimeOut());
        Runner runner = new Runner();
        pool.execute(runner);
        pool.execute(runner);
        pool.execute(runner);
        pool.execute(runner);
        Thread.sleep(8000);
        P.l("当前线程池内线的数量： "+pool.getPoolSize());*/

        ThreadPoolExecutor pool = new ThreadPoolExecutor(4, 5, 5,
                TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        //设置允许核心线程超时（必须在任务提交前设置）,如果为true，则线空闲5秒后销毁
        pool.allowCoreThreadTimeOut(true);
        P.l("是否允许核心线程超时:"+pool.allowsCoreThreadTimeOut());
        Runner runner = new Runner();
        pool.execute(runner);
        pool.execute(runner);
        pool.execute(runner);
        pool.execute(runner);
        Thread.sleep(8000);
        P.l("当前线程池内线的数量： "+pool.getPoolSize());
    }

    static class Runner implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " run " + System.currentTimeMillis());
        }
    }
}