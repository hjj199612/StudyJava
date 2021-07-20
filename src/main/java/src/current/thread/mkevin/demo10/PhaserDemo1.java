package src.current.thread.mkevin.demo10;

import java.util.concurrent.Phaser;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Phaser的正常使用
 */
public class PhaserDemo1 {

    public static void main(String[] args) throws InterruptedException {

        //Phaser(5)代表注册的party数量, 不传入默认为0
        Phaser phaser = new Phaser(5);
        new Runner(phaser).start();
        Thread.sleep(ThreadLocalRandom.current().nextInt(1000));
        new Runner(phaser).start();
        Thread.sleep(ThreadLocalRandom.current().nextInt(1000));
        new Runner(phaser).start();
        Thread.sleep(ThreadLocalRandom.current().nextInt(1000));
        new Runner(phaser).start();
        Thread.sleep(ThreadLocalRandom.current().nextInt(1000));
        new Runner(phaser).start();
    }

    static  class Runner extends  Thread{

        private Phaser phaser;

        // 多个线程必须持有同一个phaser
        public Runner(Phaser phaser){
            this.phaser=phaser;
        }

        @Override
        public void run() {
            try {
                System.out.println(this.getName()+" is ready1");
                phaser.arriveAndAwaitAdvance();
                System.out.println(this.getName()+" running...");
                Thread.sleep(ThreadLocalRandom.current().nextInt(3000));
                System.out.println(this.getName()+" is ready2");
                phaser.arriveAndAwaitAdvance();
                System.out.println(this.getName()+" running...");
                Thread.sleep(ThreadLocalRandom.current().nextInt(3000));
                System.out.println(this.getName()+" is ready3");
                phaser.arriveAndAwaitAdvance();
                Thread.sleep(ThreadLocalRandom.current().nextInt(3000));
                System.out.println(this.getName()+" over");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}