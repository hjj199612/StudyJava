package src.current.thread.mkevin.demo19;

import src.current.thread.mkevin.entity.P;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class BeforAfterTerminatedDemo {
    public static void main(String[] args) throws InterruptedException {
        P.o("线程执行前后加入切面，线程池关闭后增加切面");
        ThreadPoolExecutorDemo executor = new ThreadPoolExecutorDemo(2, 2,
                Integer.MAX_VALUE, TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>());
        executor.execute(new Runner("A1"));
        executor.execute(new Runner("A2"));
        executor.execute(new Runner("A3"));
        executor.execute(new Runner("A4"));
        //shutdown之后terminated执行
        executor.shutdown();
    }
}

public class Runner implements Runnable {
    private String name;

    public Runner(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        P.l(name + " run " + System.currentTimeMillis());
    }
}

// 实现自己的线程池，复写beforeExecute和afterExecute方法
class ThreadPoolExecutorDemo extends ThreadPoolExecutor {
    public ThreadPoolExecutorDemo(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        P.l("before " + ((Runner) r).getName() + " run");
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        P.l("after " + ((Runner) r).getName() + " run");
    }

    //线程池终止时执行
    protected void terminated() {
        super.terminated();
        P.l("ThreadPoolExecutor is terminated");
    }


}