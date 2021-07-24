package current.thread.mkevin.demo12;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ThreadLocalRandom;

public class RecursiveAction0 extends RecursiveAction {
    private int beginValue;
    private int endValue;

    public RecursiveAction0(int beginValue, int endValue) {
        super();
        this.beginValue = beginValue;
        this.endValue = endValue;
    }

    @Override
    protected void compute() {
        System.out.println(Thread.currentThread().getName() + " start compute");
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (endValue - beginValue > 2) {
            //计算中间值
            int middelNum = (beginValue + endValue) / 2;
            //左计算
            RecursiveAction0 leftAction = new RecursiveAction0(beginValue, middelNum);
            //右计算
            RecursiveAction0 rightAction = new RecursiveAction0(middelNum + 1, endValue);
            //拆解
            this.invokeAll(leftAction, rightAction);
        } else {
            System.out.println(Thread.currentThread().getName() +  " : " + beginValue + "-" + endValue);
        }
    }
}