package src.current.thread.mkevin.demo1;

/**
 * yied让出执行权,但是不释放锁
 */
public class YieldDemo1 extends Thread {

    public static Object lock = new Object();

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println(this.getName() + " yield");
            //Kevin提醒1：打开关闭此注释查看输出效果，对比差异
            //this.yield();

            //Kevin提醒2：使用wait方法来做对比，查看释放锁与不释放锁的区别
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(this.getName() + " run over");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            YieldDemo1 demo = new YieldDemo1();
            demo.start();
        }

        //Kevin提醒2:配合wait使用看效果
        synchronized (lock) {
            lock.notifyAll();
        }
    }

}
