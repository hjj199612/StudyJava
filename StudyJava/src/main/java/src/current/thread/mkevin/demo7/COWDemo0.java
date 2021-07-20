package src.current.thread.mkevin.demo7;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * CopyOnWriteArrayList 的迭代器也为弱一致性迭代器
 */
public class COWDemo0 {

    public static void main(String[] args) throws InterruptedException {

        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Iterator<Integer> iterator = list.iterator();

        Thread td = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                list.add(4);
                list.add(5);
            }
        });

        td.start();
        td.join();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("------------------");

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

    }

}
