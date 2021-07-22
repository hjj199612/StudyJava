package src.current.thread.mkevin.demo12;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * 使用类RecursiveTask执行的任务具有返回值的功能。
 * get、join方法都可以获取
 */
public class ForkJoinDemo1 {

    /**
     * 测试使用get方法获取运行结果, 需要捕获InterruptedException、ExecutionException
     */
    public static void testGet() {
        RecursiveTask1 task1 = new RecursiveTask1();
        System.out.println(task1.hashCode());
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Integer> result = pool.submit(task1);
        try {
            Integer get = result.get();
            System.out.println(result.hashCode() + " " + get);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    /**
     * 测试使用join方法获取结果，无需捕获异常，任务发生异常时直接抛出
     */
    public static void testJoin(){
        RecursiveTask1 task1 = new RecursiveTask1();
        System.out.println(task1.hashCode());
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Integer> result = pool.submit(task1);
        Integer join = result.join();
        System.out.println(result.hashCode() + " " + join);
    }


    public static void main(String[] args) {
       //testGet();
       testJoin();
    }
}
