package src.current.thread.mkevin.demo17;

import src.current.thread.mkevin.entity.P;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class prestartAllCoreThreadsDemo {
    public static void main(String[] args) throws InterruptedException {

        //prestartCoreThread启动1个核心线程，
        //这将覆盖仅在执行新任务时启动核心线程的默认策略。
        //如果所有核心线程都已启动，则此方法将返回false。
        /*ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2, 5,
                TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
        P.l("线程池中的线程数:" + executor.getPoolSize());
        P.l(executor.prestartCoreThread());
        P.l("线程池中的线程数:" + executor.getPoolSize());
        P.l(executor.prestartCoreThread());
        P.l("线程池中的线程数:" + executor.getPoolSize());
        P.l(executor.prestartCoreThread());
        P.l(executor.prestartCoreThread());
        P.l("线程池中的线程数:" + executor.getPoolSize());*/

        //prestartAllCoreThreads启动所有核心线程。
        //这将覆盖仅在执行新任务时启动核心线程的默认策略。
        //如果核心线程全部启动后再次调用，则会返回0
        Runner runner = new Runner();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2, 5,
                TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
        P.l("线程池中的线程数:" + executor.getPoolSize());
        P.l("启动核心线程数量为：" +executor.prestartAllCoreThreads());
        P.l("线程池中的线程数:" + executor.getPoolSize());
        P.l("启动核心线程数量为：" +executor.prestartAllCoreThreads());
    }

    static class Runner implements Runnable {
        @Override
        public void run() {
            P.l(Thread.currentThread().getName() + " run " + System.currentTimeMillis());
        }
    }
}