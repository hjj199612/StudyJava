package current.thread.mkevin.demo12;

import java.util.concurrent.RecursiveTask;

/**
 * 返回Double结果
 */
public class RecursiveTask2 extends RecursiveTask<Double> {
    @Override
    protected Double compute() {
        try {
            System.out.println(Thread.currentThread().getName() + " begin RecursiveTask2 " + System.currentTimeMillis());
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + " end RecursiveTask2 " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 123.456D;
    }
}
