package src.current.thread.mkevin.demo1;

/**
 * join方法使用demo
 */
public class JoinDemo0 {

    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" run over!");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" run over!");
            }
        });

        t1.start();
        t2.start();

        System.out.println(Thread.currentThread().getName()+" wait "+t1.getName()+" and " + t2.getName() + " run over!");

        //Kevin提醒：打开和关闭此段注释观察执行效果,来理解join的用途
        /*try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        //Kevin提醒：打开和关闭此段注释观察执行效果,来理解join(millis)的用途
        try {
            //t1.join(1000);
            //t2.join(1000);
            t1.join(1000,500);
            t2.join(1000,500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("final:"+t1.getName()+" and " + t2.getName() + " run over!");

        //查看线程状态
        System.out.println("t1's state:"+t1.getState());
        System.out.println("t2's state:"+t2.getState());

    }

}
