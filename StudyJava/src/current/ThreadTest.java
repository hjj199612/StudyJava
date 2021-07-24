package current;

/**
 * @Description:
 * @Author: huangjj24
 * @CreateDate: 2021-1-1 9:51
 **/
public class ThreadTest extends Thread {
    public void run() {
        System.out.println("线程" + currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadTest threadTest = new ThreadTest();
        threadTest.start();
        Thread.sleep(Integer.MAX_VALUE);
    }
}
