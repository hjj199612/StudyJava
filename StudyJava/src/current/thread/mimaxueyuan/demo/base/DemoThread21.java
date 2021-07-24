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
 * 使用ThreadLocal
 * 可以保证变量被每个线程度
 * 
 * @author: Kevin
 * @官网: 	www.mimaxueyuan.com
 * @Q Q群:	660567408
 * @Email:	mimaxueyuan@163.com
 * [每天进步一点点、人生带来大改变...]
 * [本代码对应视频地址:http://study.163.com/course/introduction/1004176043.htm]
 */
public class DemoThread21 {
	public static void main(String[] args) throws InterruptedException {
		
		final ThreadLocal<Integer> th = new ThreadLocal<Integer>();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					th.set(100);
					System.out.println("t1 set th="+th.get());
					Thread.sleep(2000);
					System.out.println("t1 get th="+th.get());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		Thread.sleep(1000);
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				Integer ele = th.get();
				System.out.println("t2 get th="+ele);
				th.set(200);
				System.out.println("t2 get th="+th.get());
			}
		}).start();
		
	}
}
