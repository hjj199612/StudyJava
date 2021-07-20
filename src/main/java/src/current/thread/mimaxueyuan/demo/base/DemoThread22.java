/**   
 * 
 * @Title: DemoThread09.java 
 * @Prject: DemoThread
 * @Package: com.liang.demo 
 * @author: yin.hl
 * @date: 2017年3月20日 下午10:55:51 
 * @version: V1.0   
 */
package src.current.thread.mimaxueyuan.demo.base;

/**
 * notify 与 notifyAll的区别
 * 
 * notifyAll 使所有原来在该对象上等待被notify的线程统统退出wait的状态，变成等待该对象上的锁，一旦该对象被解锁，他们就会去竞争。
 * 
 * notify 则文明得多他只是选择一个wait状态线程进行通知，并使它获得该对象上的锁，
 * 但不惊动其他同样在等待被该对象notify的线程们，当第一个线程运行完毕以后释放对象上的锁此时如果该对象没有再次使用notify语句，
 * 则即便该对象已经空闲，其他wait状态等待的线程由于没有得到该对象的通知，继续处在wait状态，
 * 直到这个对象发出一个notify或notifyAll，它们等待的是被notify或notifyAll，而不是锁。
 * 
  * @author: Kevin
 * @官网: 	www.mimaxueyuan.com
 * @Q Q群:	660567408
 * @Email:	mimaxueyuan@163.com
 * [每天进步一点点、人生带来大改变...]
 * [本代码对应视频地址:http://study.163.com/course/introduction/1004176043.htm]
 */
public class DemoThread22 {

	public synchronized void run1() {
		System.out.println("进入run1方法..");
		this.notifyAll();
//		this.notify();
		System.out.println("run1执行完毕,通知完毕..");
	}

	public synchronized void run2() {
		try {
			System.out.println("进入run2方法..");
			this.wait();
			System.out.println("run2执行完毕..");
//			this.notify();
//			System.out.println("run2发出通知..");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void run3() {
		try {
			System.out.println("进入run3方法..");
			this.wait();
			System.out.println("run3执行完毕..");
//			this.notify();
//			System.out.println("run3发出通知..");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {

		final DemoThread22 demo = new DemoThread22();

		new Thread(new Runnable() {

			@Override
			public void run() {
				demo.run2();
			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				demo.run3();
			}
		}).start();
		
		Thread.sleep(1000L);
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				demo.run1();
			}
		}).start();
	}
}
