package current.thread.mkevin.demo13;

import src.current.thread.mkevin.entity.P;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 线程工场
 */
class DemoThreadFactory implements ThreadFactory {

    // 是否记录日志
    private boolean saveLog;
    // 工场名称
    private String factoryName;

    public DemoThreadFactory(String factoryName, boolean saveLog) {
        this.factoryName = factoryName;
        this.saveLog = saveLog;
    }

    public Thread newThread(Runnable r) {
        if (saveLog) {
            //动态输出日志
            P.l(System.currentTimeMillis() + this.factoryName + " create start");
        }
        Thread thread = new Thread(r);
        //自定义线程名字
        thread.setName("Kevin-Thread-" + thread.getName() + ":" + thread.getId());
        try {
            //模拟初始化时间
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (saveLog) {
            P.l(System.currentTimeMillis() + this.factoryName + " " + thread.getName() + " create end");
        }
        return thread;
    }
}