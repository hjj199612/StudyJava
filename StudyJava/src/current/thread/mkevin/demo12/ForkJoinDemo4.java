package current.thread.mkevin.demo12;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

/**
 * 分治模型典型例子
 */
public class ForkJoinDemo4 {
    public static void main(String[] args) throws InterruptedException {
        try {
            RecursiveTask4 task = new RecursiveTask4(1, 10);
            ForkJoinPool pool = new ForkJoinPool();
            pool.submit(task);
            System.out.println("result：" + task.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
