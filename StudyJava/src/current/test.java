package current;

import java.util.concurrent.Semaphore;

/**
 * @Description:
 * @Author: huangjj24
 * @CreateDate: 2021-1-1 9:50
 **/
public class test {


    public Semaphore h = new Semaphore(2);
    protected Semaphore o = new Semaphore(2);
    Semaphore y = new Semaphore(2);
    private Semaphore z = new Semaphore(2);
    protected void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        h.acquire(1);
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        o.release(1);
    }

    void oxygen(Runnable releaseOxygen) throws InterruptedException {
        o.acquire(2);
        // releaseOxygen.run() outputs "H". Do not change or remove this line.
        releaseOxygen.run();
        h.release(2);
    }
}
