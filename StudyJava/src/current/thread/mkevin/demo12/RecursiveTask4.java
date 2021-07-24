package current.thread.mkevin.demo12;

import src.current.thread.mkevin.entity.P;

import java.util.concurrent.RecursiveTask;

public class RecursiveTask4 extends RecursiveTask<Integer> {
    private int begin;
    private int end;

    public RecursiveTask4(int begin, int end) {
        super();
        this.begin = begin;
        this.end = end;
    }

    protected Integer compute() {
        P.l(Thread.currentThread().getName() + " start compute ["+ begin +","+ end +"]");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //拆分条件
        if ((end - begin) != 0) {
            //计算中间值
            int mid = (end + begin) / 2;
            //分治为左右任务
            RecursiveTask4 leftTask = new RecursiveTask4(begin, mid);
            RecursiveTask4 rightTask = new RecursiveTask4(mid + 1, end);
            this.invokeAll(leftTask, rightTask);
            //汇总左右结果
            Integer leftResult = leftTask.join();
            Integer rightResult = rightTask.join();
            P.l(Thread.currentThread().getName() + " compute "+ leftResult +"+"+ rightResult +"="+(leftResult + rightResult));
            return leftResult + rightResult;
        } else {
            //无法拆分时,返回结果
            return end;
        }
    }
}