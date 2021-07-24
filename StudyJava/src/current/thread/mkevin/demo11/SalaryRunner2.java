package current.thread.mkevin.demo11;

/**
 * 结果计算
 */
public class SalaryRunner2 implements Runnable {

    //结果
    private Result result;
    //工资
    private long salary;
    //耗时
    private long costTime;

    public SalaryRunner2(Result result,long salary, long costTime){
        this.result = result;
        this.costTime = costTime;
        this.salary=salary;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(this.costTime);
            this.result.setValue(this.salary*1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}