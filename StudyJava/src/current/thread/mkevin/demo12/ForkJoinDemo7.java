package current.thread.mkevin.demo12;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinDemo7 {

    public static void main(String[] args){
        //testShutdown();
        testShutdownNow();
    }

    //测试一下shutdown方法~ 哈~~
    private static void testShutdown(){
        Runnable7 myRunnable = new Runnable7();
        ForkJoinPool pool = new ForkJoinPool();
        pool.submit(myRunnable);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //关闭，已经提交的任务可以继续运行到结束，但是后进来的~~ 老子不接收了，触发RejectedExecutionException
        pool.shutdown();
        System.out.println("already shutdown! ");
        if(!pool.isShutdown()) { //尝试注释if，会发生什么？boom！飚异常了~~
            //如果没关闭则可以提交任务
            pool.submit(myRunnable);
        }
        System.out.println("main end! ");
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //测试一下shutdownNow方法~ 哈~~ 特别暴力
    private static void testShutdownNow(){
        Runnable7 myRunnable = new Runnable7();
        ForkJoinPool pool = new ForkJoinPool();
        pool.submit(myRunnable);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //关闭，已经提交的任务中断，触发InterruptedException，但是后进来的~~ 老子不接收了，触发RejectedExecutionException
        pool.shutdownNow();
        System.out.println("already shutdown! ");
        if(!pool.isShutdown()) { //尝试注释if，会发生什么？boom！飚异常了~~
            //如果没关闭则可以提交任务
            pool.submit(myRunnable);
        }
        System.out.println("main end! ");
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}