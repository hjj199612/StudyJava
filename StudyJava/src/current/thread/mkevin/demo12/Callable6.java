package current.thread.mkevin.demo12;

import current.thread.mkevin.entity.P;

import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class Callable6 implements Callable<String> {

    private String name;

    public Callable6(String name) {
        super();
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        try {
            int sleep = ThreadLocalRandom.current().nextInt(3000);
            P.l(this.name+" sleep " + sleep);
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.name;
    }
}