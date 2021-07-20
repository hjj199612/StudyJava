package src.current.thread.mkevin.demo1;

/**
 * isInterrupted 与 interrupt 的使用
 */
public class InterruptDemo1 {

    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //3.条件为!true=false,退出循环
                //5.如果这里更换为Thread.currentThread().isInterrupted()
                while(!Thread.currentThread().isInterrupted()){

                }
                //4.这里输出的是什么true还是false
                //6.这里输出的是什么true还是false
                System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().isInterrupted());
            }
        });

        //1.开启
        t1.start();

        //2.中断标记设置为true
        t1.interrupt();

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main is run over");

    }

}
