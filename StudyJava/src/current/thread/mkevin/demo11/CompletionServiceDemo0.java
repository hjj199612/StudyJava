package current.thread.mkevin.demo11;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CompletionServiceDemo0 {
    public static void main(String[] args) {
        try {
            //创建线程池
            ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 10, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
            //创建CompletionService, 需要借助Executor来实现
            CompletionService cs = new ExecutorCompletionService(executor);
            //创建回调线程
            SalaryCallable0 sc1 = new SalaryCallable0(300, 3000);
            SalaryCallable0 sc2 = new SalaryCallable0(200, 2000);
            SalaryCallable0 sc3 = new SalaryCallable0(100, 1000);
            //提交到线程池执行
            cs.submit(sc1);
            cs.submit(sc2);
            cs.submit(sc3);

            for (int i = 0; i < 3; i++) {
                //阻塞-take获取已经处理结束的结果, 最先处理结束的，最先得到
                Future f = cs.take();
                //非阻塞-poll, 获取不到则返回null
                //Future f = cs.poll();
                //阻塞固定时间-到时间获取不到则返回null
                //Future f = cs.poll(2,TimeUnit.SECONDS);
                System.out.println("result("+i+")="+f.get());
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}