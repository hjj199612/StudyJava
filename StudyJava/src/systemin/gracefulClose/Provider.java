package systemin.gracefulClose;

/**
 * @author huangjj24
 * @date 2021-7-30 16:58
 **/
public class Provider{
    private final static Object MONITOR = new Object();

    public void start() throws Exception{
        registerHook();
        doStart();
        waitShutdown();
    }

    protected void doStart(){
        // 启动加载逻辑
    }

    public void shutdown(){
        // 关闭逻辑
    }

    private void registerHook(){
        // 	注册关闭钩子事件
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("shutdown hook!");
            Provider.this.shutdown();
        }));
    }

    private void waitShutdown() throws Exception{
        synchronized(MONITOR){
            MONITOR.wait();
        }
    }
}

