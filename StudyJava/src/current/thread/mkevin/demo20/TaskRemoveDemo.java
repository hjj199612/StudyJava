package current.thread.mkevin.demo20;

import src.current.thread.mkevin.entity.P;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TaskRemoveDemo {
    public static void main(String[] args) throws InterruptedException {

        /*P.o("运行中的任务不能删除的~ 你想啥呢....");
        Runner runner = new Runner();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 100,
                TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        executor.execute(runner);
        Thread.sleep(1000);
        P.l("线程池中的任务数:"+executor.getTaskCount());
        boolean remove = executor.remove(runner);
        P.l(remove);
        P.l("线程池中的任务数:"+executor.getTaskCount());*/

        /*P.o("execute方法提交的任务，未运行时可以删除~");
        Runner runner1 = new Runner();
        Runner runner2 = new Runner();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 100,
                TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        executor.execute(runner1);
        executor.execute(runner2);
        Thread.sleep(1000);
        P.l("线程池中的任务数:"+executor.getTaskCount());
        boolean remove = executor.remove(runner2);
        P.l(remove);
        P.l("线程池中的任务数:"+executor.getTaskCount());*/

        P.o("submit方法提交的任务，未运行时不可以删除~ 大坑！！！");
        Runner runner1 = new Runner();
        Runner runner2 = new Runner();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 100,
                TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        executor.submit(runner1);
        executor.submit(runner2);
        Thread.sleep(1000);
        P.l("线程池中的任务数:"+executor.getTaskCount());
        boolean remove = executor.remove(runner2);
        P.l(remove);
        P.l("线程池中的任务数:"+executor.getTaskCount());
    }

    static class Runner implements Runnable {
        @Override
        public void run() {
            P.l(Thread.currentThread().getName() + " run " + System.currentTimeMillis()+ " start");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            P.l(Thread.currentThread().getName() + " run " + System.currentTimeMillis()+ " end");
        }
    }
}