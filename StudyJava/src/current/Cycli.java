package current;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Description:
 * @Author: huangjj24
 * @CreateDate: 2021-4-8 17:56
 **/
public class Cycli {
    // synchronized Cycli(){
    //
    // }
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier=new CyclicBarrier(10,()->{
            System.out.println("全员到齐，出发");
        });
        for (int i = 1; i <=10; i++) {
            new Thread(()->{
                try {
                    System.out.println(Thread.currentThread().getName()+"到，");
                    //类似于点名，到一个人调用这个方法进行加一操作,然后等十个人都到齐后，放开屏障，再进行下一步
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName()+"走，");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },i+"").start();
        }
    }
}
