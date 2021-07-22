package src.current.thread.mkevin.demo12;

import java.util.concurrent.RecursiveTask;

/**
 * 返回String结果
 */
public class RecursiveTask3 extends RecursiveTask<String> {
    @Override
    protected String compute() {
        try {
            System.out.println(Thread.currentThread().getName() + " begin RecursiveTask3 " + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + " end RecursiveTask3 " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "RecursiveTask3's String Result";
    }
}
