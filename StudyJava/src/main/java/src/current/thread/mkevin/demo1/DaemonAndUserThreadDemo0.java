package src.current.thread.mkevin.demo1;

/**
 * 守护线程和用户线程Demo
 */
public class DaemonAndUserThreadDemo0 {

    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){

                }
            }
        });

        //Kevin提醒：打开和关闭这个设置观察JVM进程是否终止
        //thread.setDaemon(true);

        thread.start();

        //输出线程是否为守护线程
        System.out.println(thread.getName() +" is daemon? "+ thread.isDaemon());
        System.out.println(Thread.currentThread().getName() +" is daemon? "+ Thread.currentThread().isDaemon());

        System.out.println("main is over");
    }
}
