package current.thread.mimaxueyuan.demo.high.base;

import java.util.concurrent.Exchanger;

/**
 * @author: Kevin
 * @官网: 	www.mimaxueyuan.com
 * @Q Q群:	660567408
 * @Email:	mimaxueyuan@163.com
 * [每天进步一点点、人生带来大改变...]
 * [本代码对应视频地址:http://study.163.com/course/introduction/1004176043.htm]
 */
public class ExchangerTest1 {

	public static void main(String[] args) {
		Exchanger<String> exchanger = new Exchanger<String>();
		ExchangerRunnable exchangerRunnable1 = new ExchangerRunnable(exchanger, "A");
		ExchangerRunnable exchangerRunnable2 = new ExchangerRunnable(exchanger, "B");
		
//		new Thread(exchangerRunnable1).start();
//		new Thread(exchangerRunnable2).start();
		
		Exchanger<String> exchanger2 = new Exchanger<String>();
		ExchangerRunnable exchangerRunnable3 = new ExchangerRunnable(exchanger2, "C");
		ExchangerRunnable exchangerRunnable4 = new ExchangerRunnable(exchanger2, "D");
		new Thread(exchangerRunnable1).start();
		new Thread(exchangerRunnable2).start();
		new Thread(exchangerRunnable3).start();
		new Thread(exchangerRunnable4).start();
	}
}

class ExchangerRunnable implements Runnable {

	Exchanger<String> exchanger = null;
	String object = null;

	public ExchangerRunnable(Exchanger<String> exchanger, String object) {
		this.exchanger = exchanger;
		this.object = object;
	}

	public void run() {
		try {
			Object previous = this.object;
			System.out.println(Thread.currentThread().getName() +"交换前："+this.object);
			if("C".equals(previous)){
				Thread.sleep(3000);
				System.out.println(Thread.currentThread().getName() +"对数据C的处理耗时3s");
			}else if("D".equals(previous)){
				Thread.sleep(4000);
				System.out.println(Thread.currentThread().getName() +"对数据D的处理耗时4s");
			}else if("A".equals(previous)){
				Thread.sleep(3000);
				System.out.println(Thread.currentThread().getName() +"对数据A的处理耗时3s");
			}else if("B".equals(previous)){
				Thread.sleep(4000);
				System.out.println(Thread.currentThread().getName() +"对数据B的处理耗时4s");
			}
			//两个对象必须在此处汇合,只有一个线程调用change方法是不会进行数据交换的
			this.object = this.exchanger.exchange(this.object);
			System.out.println(Thread.currentThread().getName() + " 交换后: " + this.object);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
