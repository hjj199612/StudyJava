package current.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author huangjj24
 * @date 2021-7-19 11:30
 **/
public class AtomicTest {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        atomicInteger.addAndGet(1);
    }
}
