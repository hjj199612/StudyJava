package current.thread.mkevin.demo14;


import current.thread.mkevin.entity.P;

public class ThreadPoolDemo1 {
    public static void main(String[] args) throws InterruptedException {

        // 创建线程池，而不提交任何任务，则无任何线程被创建，程序直接运行结束
        /*ExecutorService executorService = Executors.newCachedThreadPool();
        P.l("main is over");*/

        // 创建线程池，并向线程池提交任务，则创建线程，任务执行完毕而线程不销毁，JVM继续运行
        // 等待60秒后，自动销毁空闲线程，JVM退出
        /*Runner runner = new Runner();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(runner);
        P.l("main is over");*/


        // 创建线程池，并向线程池提交任务，则创建线程，任务执行完毕而线程不销毁，JVM继续运行
        // 始终保持有1个线程存活，所以JVM不会退出
        /*Runner runner = new Runner();
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(runner);
        P.l("main is over");*/

        //shutdown让线程池内的任务继续执行完毕，但是不允许新的任务提交，shutdow方法不阻塞
        //等所有线程执行完毕后， 销毁线程，JVM退出
        /*Runner runner = new Runner();
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(runner);
        executorService.shutdown();
        P.l("main is over");*/

        //shutdown之后提交的任务会抛出RejectedExecutionException异常，代表拒绝接收
        /*Runner runner = new Runner();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(runner);
        executorService.shutdown();
        P.l("main is over");
        executorService.submit(runner);*/

        //shutdownNow之后提交的任务会抛出RejectedExecutionException异常，代表拒绝接收
        //shutdownNow之后会引发sleep、join、wait方法的InterruptedException异常
        /*ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(new Runner());
        executorService.shutdownNow();
        P.l("main is over");
        executorService.submit(new Runner());*/

        //如果任务中没有触发InterruptedException的条件，则任务会继续运行直到结束
        /*ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(new Runner1());
        executorService.shutdownNow();
        P.l("main is over");*/

        //可以在任务中判断Thread.currentThread().isInterrupted()来规避shutdownNow的问题
        /*ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(new Runner2());
        executorService.shutdownNow();
        P.l("main is over");*/
    }

    static class Runner implements Runnable {
        public void run() {
            try {
                P.l(Thread.currentThread().getName()+" begin");
                Thread.sleep(4000);
                P.l(Thread.currentThread().getName()+" end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //不做特殊处理的任务，无法规避shutdownNow的问题
    static class Runner1 implements Runnable {
        public void run() {
            while(true){
                P.l(Thread.currentThread().getName()+ " " + System.currentTimeMillis());
            }
        }
    }

    //判断线程是否Interrupted的程序，规避shutdownNow的问题
    static class Runner2 implements Runnable {
        public void run() {
            while(true){
                P.l(Thread.currentThread().getName()+ " " + System.currentTimeMillis());
                if(Thread.currentThread().isInterrupted()){
                    P.l(Thread.currentThread().getName()+ " interrupted");
                    break;
                }
            }
        }
    }
}