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
 * synchronized代码块 做到更细粒度的控制
 * 
  * @author: Kevin
 * @官网: 	www.mimaxueyuan.com
 * @Q Q群:	660567408
 * @Email:	mimaxueyuan@163.com
 * [每天进步一点点、人生带来大改变...]
 * [本代码对应视频地址:http://study.163.com/course/introduction/1004176043.htm]
 */

public class DemoThread11 {

	public void execute() {
		try {
			System.out.println("线程" + Thread.currentThread().getName() + "执行不需要同步的内容1");
			Thread.sleep(2000);
			synchronized (this) {
				System.out.println("线程" + Thread.currentThread().getName() + "执行需要同步的内容2");
				Thread.sleep(2000);
			}
			Thread.sleep(2000);
			System.out.println("线程" + Thread.currentThread().getName() + "执行不需要同步的内容3");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		final DemoThread11 demo = new DemoThread11();
		new Thread(new Runnable() {
			@Override
			public void run() {
				demo.execute();
			}
		}, "t1").start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				demo.execute();
			}
		}, "t2").start();
	}
}
