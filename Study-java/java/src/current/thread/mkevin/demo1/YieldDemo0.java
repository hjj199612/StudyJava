package src.current.thread.mkevin.demo1;

/**
 * yied让出执行权,但是不释放锁
 */
public class YieldDemo0 extends Thread{

    @Override
    public void run() {
        System.out.println(this.getName()+" yield");
        //Kevin提醒：打开关闭此注释查看输出效果，对比差异
        this.yield();
        System.out.println(this.getName()+" run over");
}

    public static void main(String[] args) {
        for(int i=0;i<10000;i++){
            YieldDemo0 demo = new YieldDemo0();
            demo.start();
        }
    }

}
