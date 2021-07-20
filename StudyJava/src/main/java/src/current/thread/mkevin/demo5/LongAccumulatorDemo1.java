package src.current.thread.mkevin.demo5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.function.LongBinaryOperator;

/**
 * LongAccumulator是LongAdder的功能增强版。LongAdder的API只有对数值的加减，而LongAccumulator提供了自定义的函数操作
 *
 * https://blog.csdn.net/fouy_yun/article/details/77825039
 */
public class LongAccumulatorDemo1 {

    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();

        LongBinaryOperator lbn = new LongBinaryOperator() {
            @Override
            public long applyAsLong(long left, long right) {
                return left+right*2+ ThreadLocalRandom.current().nextInt(10);
            }
        };

        LongAccumulator la = new LongAccumulator(lbn,1);
        System.out.println("KEVIN初始值:"+la.longValue());

        List<Thread> list = new ArrayList<>();
        for(int i=0;i<1000;i++){
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    la.accumulate(2);
                }
            });
            list.add(t);
        }

        for(Thread th : list){
            th.start();
        }

        for(Thread th : list){
            th.join();
        }

        long end = System.currentTimeMillis();

        System.out.println("耗时:"+(end-start)+",KEVIN结果:"+la.longValue());

    }

}
