package src.current.thread.pool;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author huangjj24
 * @date 2021-7-19 14:06
 **/
public class ThreadPoolExecutorTest {

    static volatile int i = 0;

    static class MyThread implements Runnable {
        @Override
        public void run() {
            System.out.println(i++);
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor poolExecutor =
                new ThreadPoolExecutor(1, 1,
                        100, TimeUnit.SECONDS, getWorkQueue());
        MyThread myThread = new MyThread();
        poolExecutor.execute(myThread);
        Future<?> submit = poolExecutor.submit(myThread);
        poolExecutor.shutdown();
        List<Runnable> runnables = poolExecutor.shutdownNow();
        Callable<Object> callable = Executors.callable(myThread);
        FutureTask<Object> futureTask = new FutureTask<Object>(callable);
        myThread.run();
        Object o = futureTask.get();
        System.out.println(o);
        //
        boolean f1 = poolExecutor.isShutdown();
        //
        boolean f2 = poolExecutor.isTerminated();
        //
        boolean f3 = poolExecutor.isTerminating();
    }

    private static BlockingQueue<Runnable> getWorkQueue() {
        ArrayBlockingQueue<Runnable> objects = new ArrayBlockingQueue<>(200);
        for (int j = 0; j < 100; j++) {
            objects.add(new MyThread());
        }
        return objects;
    }
}
