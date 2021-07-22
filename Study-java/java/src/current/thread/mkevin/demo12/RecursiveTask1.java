package src.current.thread.mkevin.demo12;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ThreadLocalRandom;

public class RecursiveTask1 extends RecursiveTask<Integer> {
    @Override
    protected Integer compute() {
        System.out.println("start compute : " + System.currentTimeMillis());
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //打开此注释,测试get和join方法获取结果时的差异
        int i=10/0;
        return ThreadLocalRandom.current().nextInt(5000);
    }
}