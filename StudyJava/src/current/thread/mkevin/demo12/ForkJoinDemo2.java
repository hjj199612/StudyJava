package current.thread.mkevin.demo12;

import src.current.thread.mkevin.entity.P;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class ForkJoinDemo2 {
    public static void main(String[] args) throws InterruptedException {
        P.o("ForkJoinPool运行不同类型的Task");
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Double> task2 = pool.submit(new RecursiveTask2());
        ForkJoinTask<String> task3 = pool.submit(new RecursiveTask3());
        P.l("接收结果：");
        P.l(task2.join());
        P.l(task3.join());
    }
}
