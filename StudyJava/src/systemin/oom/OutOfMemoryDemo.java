package systemin.oom;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author huangjj24
 * @date 2021-7-31 16:13
 * 测试OOM分析   dump文件和JVM配 置路径:
 * -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=C:\Users\huangjj24\AppData\Roaming\VisualVM\8u131\var\log\heapdump.hprof
 **/
public class OutOfMemoryDemo {

    static Map<Integer, byte[]> byteMap = new HashMap<>();
    static Map<Integer, char[]> charMap = new HashMap<>();
    static Map<Integer, MyObject[]> objectMap = new HashMap<>();

    public static void main(String[] args) {
        // ExecutorService threadPool = Executors.newFixedThreadPool(100);
        // threadPool.execute(new Thread());

        for (int i = 0; i < 1024 * 1024; i++) {
            // threadPool.submit(new Thread(() -> {
            byte[] bytes = new byte[1024 * 1024];
            byteMap.put(i, bytes);
            System.out.println(i + "bytes" + bytes);
            char[] chars = new char[1024 * 1024];
            charMap.put(i, chars);
            System.out.println(i + "chars" + chars);
            objectMap.put(i, new MyObject[1024]);

            // }));
        }
        // threadPool.shutdown();
        // while (threadPool.isTerminated()){
        //
        // }

    }

    public static class MyObject {
        int x = 0;
        MyObject[] bytes = new MyObject[1024 * 1024];
    }
}
