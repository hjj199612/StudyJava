package systemin.gracefulClose;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author huangjj24
 * @date 2021-7-30 13:50
 **/
public class GracefulClose {

    public static void main(String[] args) throws InterruptedException {
        KillHandler killHandler = new KillHandler();
        killHandler.registerSignal("TERM");
        // Thread.sleep(10000);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Thread());
    }
}
