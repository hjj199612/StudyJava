package current.thread.mkevin.demo18;

import src.current.thread.mkevin.entity.P;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolGetDemo {
    public static void main(String[] args) throws InterruptedException {
        Runner runner = new Runner();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2, 5,
                TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
        executor.execute(runner);
        executor.execute(runner);
        executor.execute(runner);
        executor.execute(runner);
        Thread.sleep(1000);
        P.l("返回核心线程数getCorePoolSize:"+executor.getCorePoolSize());
        P.l("返回当前线程池中的线程数getPoolSize:"+executor.getPoolSize());
        P.l("返回最大允许的线程数getMaximumPoolSize:"+executor.getMaximumPoolSize());
        P.l("返回池中同时存在的最大线程数getLargestPoolSize:"+executor.getLargestPoolSize());
        P.l("预定执行的任务总和getTaskCount:"+executor.getTaskCount());
        P.l("当前线程池已经完成的任务数getCompletedTaskCount:"+executor.getCompletedTaskCount());
        P.l("正在执行任务的线程的大致数目getActiveCount:"+executor.getActiveCount());
        P.l("空闲时间getKeepAliveTime:"+executor.getKeepAliveTime(TimeUnit.SECONDS));
        P.l("------------------------------------");
        Thread.sleep(1100);
        P.l("当前线程池已经完成的任务数getCompletedTaskCount:"+executor.getCompletedTaskCount());
        Thread.sleep(1100);
        P.l("当前线程池已经完成的任务数getCompletedTaskCount:"+executor.getCompletedTaskCount());
        executor.shutdown();
        P.l("当前线程池已经完成的任务数getCompletedTaskCount:"+executor.getCompletedTaskCount());
    }

    static class Runner implements Runnable {
        @Override
        public void run() {
            P.l(Thread.currentThread().getName() + " run " + System.currentTimeMillis()+ "start");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            P.l(Thread.currentThread().getName() + " run " + System.currentTimeMillis()+ "end");
        }
    }
}
