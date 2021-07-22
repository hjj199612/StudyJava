package src.current.thread.mkevin.demo1;

/**
 * isInterrupted 与 interrupt 的使用
 */
public class InterruptDemo0 {

    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //2.开始执行循环
                for(int i=0;i<999999;i++){
                    //3.判断是否为中断状态,如果是中断则退出循环
                    if(Thread.currentThread().isInterrupted()){
                        System.out.println(Thread.currentThread().getName() + " interrupted");
                        break;
                    }
                    System.out.println(Thread.currentThread().getName() + i+" is running");
                }
            }
        });

        //1.启动
        t1.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //4.调用中断,是否会中断死循环？
        t1.interrupt();

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(t1.getState());
    }

}






//KEVIN：隐藏代码段
//3.判断是否为中断状态,如果是中断则退出循环
/*if(Thread.currentThread().isInterrupted()){
    System.out.println(Thread.currentThread().getName() + " interrupted");
    break;
}*/