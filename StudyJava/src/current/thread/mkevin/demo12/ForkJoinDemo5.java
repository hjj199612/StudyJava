package current.thread.mkevin.demo12;

import current.thread.mkevin.demo11.Result;
import current.thread.mkevin.demo11.SalaryRunner2;
import current.thread.mkevin.entity.P;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * execute 可以执行Runnable和RecursiveTask，
 */
public class ForkJoinDemo5 {
    public static void main(String[] args) {
        try {
            //执行runnable任务
            ForkJoinPool pool = new ForkJoinPool();
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    P.l(Thread.currentThread().getName() + " run");
                }
            });

            ForkJoinTask<?> submit = pool.submit(new Runnable() {
                @Override
                public void run() {
                    P.l(Thread.currentThread().getName() + " run");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            //获得结果为NULL, 依然具有阻塞特性
            P.l("result01:"+submit.get());
            P.l("result02:"+submit.join());

            //提交Runnable线程任务,获取结果
            Result result = new Result();
            ForkJoinTask<Result> submit1 = pool.submit(new SalaryRunner2(result, 100, 1000), result);
            P.l("result03:"+submit1.join().getValue());
            P.l("result04:"+submit1.get().getValue());

            //execute方法无返回值,但是仍然可以使用get和join获取结果
            RecursiveTask4 task = new RecursiveTask4(1,5);
            pool.execute(task);
            P.l("result05:"+task.get());
            P.l("result06:"+task.join());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}