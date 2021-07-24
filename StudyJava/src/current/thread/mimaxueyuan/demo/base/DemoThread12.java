/**   
 * 
 * @Title: DemoThread09.java 
 * @Prject: DemoThread
 * @Package: com.liang.demo 
 * @author: yin.hl
 * @date: 2017年3月20日 下午10:55:51 
 * @version: V1.0   
 */
package current.thread.mimaxueyuan.demo.base;

/**
 * 死锁
 * 
 * @author: Kevin
 * @官网: 	www.mimaxueyuan.com
 * @Q Q群:	660567408
 * @Email:	mimaxueyuan@163.com
 * [每天进步一点点、人生带来大改变...]
 * [本代码对应视频地址:http://study.163.com/course/introduction/1004176043.htm]
 */
public class DemoThread12 {
	
	private Object lock1 = new Object();
	private Object lock2 = new Object();
	
	public void execute1() {
		synchronized (lock1) {
			System.out.println("线程" + Thread.currentThread().getName() + "获得lock1执行execute1开始");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (lock2) {
				System.out.println("线程" + Thread.currentThread().getName() + "获得lock2执行execute1开始");
			}
		}
	}

	public void execute2() {
		synchronized (lock2) {
			System.out.println("线程" + Thread.currentThread().getName() + "获得lock2执行execute2开始");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (lock1) {
				System.out.println("线程" + Thread.currentThread().getName() + "获得lock1执行execute2开始");
			}
		}
	}
	
	public static void main(String[] args) {
		final DemoThread12 demo = new DemoThread12();
		new Thread(new Runnable() {
			@Override
			public void run() {
				demo.execute1();
			}
		}, "t1").start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				demo.execute2();
			}
		}, "t2").start();
	}
}
