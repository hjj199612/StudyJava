package current.thread.mkevin.demo11;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 让Runnable也具有获得结果的特性
 */
public class CompletionServiceDemo2 {
    public static void main(String[] args) {
        try {
            //创建结果对象，用于获取结果
            Result result = new Result();
            ExecutorService executorService = Executors.newCachedThreadPool();
            CompletionService cs = new ExecutorCompletionService(executorService);
            //创建Runnable对象
            SalaryRunner2 runner1 = new SalaryRunner2(result, 10, 1000);
            SalaryRunner2 runner2 = new SalaryRunner2(result, 20, 2000);
            //提交对象, 并使用result对象接收结果
            Future<Result> f1 = cs.submit(runner1,result);
            Future<Result> f2 = cs.submit(runner2,result);
            //获取结果
            System.out.println("f1:" + f1.get().getValue());
            System.out.println("f2:" + f2.get().getValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}