package src.current.thread.mkevin.demo11;

import java.util.concurrent.Callable;

/**
 * 计算工资
 */
public class SalaryCallable1 implements Callable<Double> {

    //工资
    private double salary;
    //耗时
    private long costTime;

    public SalaryCallable1(double salary, long costTime) {
        this.salary = salary;
        this.costTime = costTime;
    }

    @Override
    public Double call() throws Exception {
        System.out.println(Thread.currentThread().getName()+" sleep="+costTime+" salary*costTime="+salary*costTime);
        Thread.sleep(costTime);
        int i=10/0;
        return salary*costTime;
    }
}