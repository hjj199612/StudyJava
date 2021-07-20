package src.current.thread.mkevin.demo10;

import src.current.thread.mkevin.entity.P;

import java.util.concurrent.Phaser;

public class PhaserDemo3 {

    public static void main(String[] args) throws InterruptedException {

        P.o("Phaser's register 使用: 到达每个阶段执行");
        Phaser phaser = new Phaser();
        for(int i=0;i<4;i++){
            phaser.register();
            new Thread(new Runner(phaser,i)).start();
        }
    }

    static class Runner implements Runnable {

        private Phaser phaser;

        private int no;

        public Runner(Phaser phaser,int no) {
            this.phaser = phaser;
            this.no = no;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " start");
                phaser.arriveAndAwaitAdvance();
                System.out.println(Thread.currentThread().getName() + " running 1");
                if (no == 1) {
                    int a = 10 / 0;
                    /*phaser.arriveAndDeregister();
                    return;*/
                }
                System.out.println(Thread.currentThread().getName() + " running 2");
                if (no == 3) {
                    phaser.arriveAndDeregister();
                    return;
                }
                phaser.arriveAndAwaitAdvance();
                System.out.println(Thread.currentThread().getName() + " end");
            }catch(Exception ex){
                ex.printStackTrace();
                phaser.arriveAndDeregister();
            }

        }
    }

}
