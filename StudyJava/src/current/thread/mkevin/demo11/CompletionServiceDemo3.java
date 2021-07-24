package current.thread.mkevin.demo11;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CompletionServiceDemo3 {
    public static void main(String[] args) throws InterruptedException {
        //创建线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 10, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
        //创建CompletionService, 需要借助Executor来实现
        CompletionService cs = new ExecutorCompletionService(executor);

        //一个线程不断产生任务
        Thread t0 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<100;i++){
                    SalaryCallable0 sc1 = new SalaryCallable0(300, ThreadLocalRandom.current().nextInt(2000));
                    cs.submit(sc1);
                }
            }
        });

        t0.start();

        //一个线程不断处理结果
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //阻塞-take获取已经处理结束的结果, 最先处理结束的，最先得到
                Future f = null;
                try {
                    while (true) {
                        f = cs.take();
                        System.out.println(Thread.currentThread().getName() + " getResult = " + f.get());
                    }
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();

        t0.join();
        t1.join();

        executor.shutdown();
    }
}