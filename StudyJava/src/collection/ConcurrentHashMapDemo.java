package collection;

import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author hjj199612
 * @date 2021/7/30 11:13 下午
 * @description ConcurrentHashMap不一定线程安全
 */
public class ConcurrentHashMapDemo {

    static ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
    static Hashtable<Integer, Integer> hashtable = new Hashtable<>();
    static ConcurrentHashMap<Integer, AtomicInteger> mapAtomic = new ConcurrentHashMap<>();
    static AtomicInteger n = new AtomicInteger(0);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 1000; i++) {
            executorService.submit(new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    map.put(j, map.getOrDefault(j, 0) + 1);
                    hashtable.put(j, hashtable.getOrDefault(j, 0) + 1);
                    AtomicInteger x = mapAtomic.getOrDefault(j, new AtomicInteger(0));
                    x.addAndGet(1);
                    mapAtomic.put(j, x);
                }
                n.addAndGet(1);
            }));
        }
        executorService.execute(new Thread());
        executorService.shutdown();
        while (!executorService.isTerminated()) {

        }
        System.out.println(map.toString());
        System.out.println(hashtable.toString());
        System.out.println(mapAtomic.toString());
        System.out.println(n.get());
    }


}
