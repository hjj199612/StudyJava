package current;

/**
 * @Description:
 * @Author: huangjj24
 * @CreateDate: 2021-4-8 17:40
 **/

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Author: 王琦 <QQ.Eamil>1124602935@qq.com</QQ.Eamil>
 * @Date: 2019-5-4 0004 9:43
 * @Description: 倒计时器示例:火箭发射
 */
public class CountDownLatchDemo implements Runnable{

    static final CountDownLatch latch = new CountDownLatch(10);
    static final CountDownLatchDemo demo = new CountDownLatchDemo();
    static final Semaphore e = new Semaphore(10);
    // private static final Unsafe unsafe = Unsafe.getUnsafe();

    @Override
    public void run() {
        // 模拟检查任务
        try {
            Thread.sleep(new Random().nextInt(10) * 100);
            System.out.println(Thread.currentThread()+"check complete");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //计数减一
            //放在finally避免任务执行过程出现异常，导致countDown()不能被执行
            latch.countDown();
        }
    }


    public static void main(String[] args) throws InterruptedException {

        ExecutorService exec = Executors.newFixedThreadPool(10);
        for (int i=0; i<10; i++){
            exec.submit(demo);
        }

        // 等待检查
        latch.await();
        // 发射火箭
        System.out.println("Fire!");
        // 关闭线程池
        exec.shutdown();
        Object s=new Object();
    }
}