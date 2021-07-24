package current.thread.mkevin.demo13;

import src.current.thread.mkevin.entity.P;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用线程工场创建线程
 */
public class ThreadFactoryDemo0 {
    public static void main(String[] args) {

        //创建任务对象
        Runnable runnable = new Runnable() {
            public void run() {
                P.l(Thread.currentThread().getName() + " run");
            }
        };

        P.o("newCachedThreadPool使用ThreadFactory");
        //创建自定义线程工场
        DemoThreadFactory threadFactory = new DemoThreadFactory("newCachedThreadPoolFactory",true);
        //使用线程工场初始化线程池
        ExecutorService executorService = Executors.newCachedThreadPool(threadFactory);
        for (int i = 0; i < 3; i++) {
            executorService.execute(runnable);
        }
        executorService.shutdown();


        P.o("newFixedThreadPool使用ThreadFactory");
        //创建自定义线程工场
        threadFactory = new DemoThreadFactory("newFixedThreadPoolFactory",true);
        //使用线程工场初始化线程池
        executorService = Executors.newFixedThreadPool(2, threadFactory);
        for(int i=0;i<3;i++){
            executorService.execute(runnable);
        }
        executorService.shutdown();

        //创建其他线程池也可以使用ThreadFactory
        //Executors.newScheduledThreadPool(2,threadFactory);
        //Executors.newSingleThreadExecutor(threadFactory);
        //Executors.newSingleThreadScheduledExecutor(threadFactory);
    }
}