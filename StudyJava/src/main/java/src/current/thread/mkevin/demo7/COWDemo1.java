package src.current.thread.mkevin.demo7;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * CopyOnWriteArraySet 的迭代器也为弱一致性迭代器
 */
public class COWDemo1 {

    public static void main(String[] args) throws InterruptedException {

        CopyOnWriteArraySet<Integer> set = new CopyOnWriteArraySet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        Iterator<Integer> iterator = set.iterator();

        Thread td = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                set.add(4);
                set.add(5);
            }
        });

        td.start();
        td.join();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("---------------------");

        iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

}
