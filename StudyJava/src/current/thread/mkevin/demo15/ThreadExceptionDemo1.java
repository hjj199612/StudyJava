package current.thread.mkevin.demo15;

import src.current.thread.mkevin.entity.P;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadExceptionDemo1 {
    public static void main(String[] args) throws InterruptedException {

        /*P.o("没有捕获异常就是一个巨大的坑~~");
        Runner1 runner1 = new Runner1();
        Runner2 runner2 = new Runner2();
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,new LinkedBlockingQueue<>());
        executorService.submit(runner1);
        executorService.submit(runner2);
        executorService.shutdown();
        P.l("main is over");*/


        P.o("优雅的处理没有捕获的异常~~");
        Runner1 runner1 = new Runner1();
        Runner2 runner2 = new Runner2();
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,new LinkedBlockingQueue<>());
        //设置ThreadFactory, 在其内部设置UncaughtExceptionHandler
        executorService.setThreadFactory(new ThreadFactory3());
        executorService.execute(runner1);
        executorService.execute(runner2);
        executorService.shutdown();
        P.l("main is over");
    }

    static class Runner1 implements Runnable {
        public void run() {
            try {
                P.l(Thread.currentThread().getName()+" run");
                int i = 10/0;
            }catch(Exception e){
                P.l(Thread.currentThread().getName()+" exception record:"+e.getMessage());
            }
        }
    }

    static class Runner2 implements Runnable {
        public void run() {
            P.l(Thread.currentThread().getName()+" run");
            int i=10/0;
        }
    }

    static class ThreadFactory3 implements ThreadFactory{

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setName("KEVIN "+System.currentTimeMillis());
            thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                @Override
                public void uncaughtException(Thread t, Throwable e) {
                    P.l(t.getName()+" exception " + e.getMessage());
                }
            });
            return thread;
        }
    }

}