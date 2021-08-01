package systemin.gracefulClose;

import sun.misc.Signal;
import sun.misc.SignalHandler;

/**
 * @author huangjj24
 * @date 2021-7-30 15:47
 * 优雅关闭
 **/
public class KillHandler implements SignalHandler {

    public void registerSignal(String signalName) {
        Signal signal = new Signal(signalName);
        Signal.handle(signal, this);
    }

    @Override
    public void handle(Signal signal) {
        if (signal.getName().equals("TERM")) {
            System.out.println("优雅关闭");
        } else if (signal.getName().equals("INT") || signal.getName().equals("HUP")) {
            //
        } else {
        }
    }
}
