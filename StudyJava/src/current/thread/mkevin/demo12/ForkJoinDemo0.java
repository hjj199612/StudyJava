package current.thread.mkevin.demo12;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinDemo0 {
    public static void main(String[] args) throws InterruptedException {
        //创建ForkJoinPool
        ForkJoinPool pool = new ForkJoinPool();
        //提交任务
        pool.submit(new RecursiveAction0(0, 9));
        Thread.sleep(Integer.MAX_VALUE);
    }
}