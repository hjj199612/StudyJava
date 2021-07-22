/**   
 * 
 * @Title: DemoThread03.java 
 * @Prject: DemoThread
 * @Package: com.liang.demo 
 * @author: yin.hl
 * @date: 2017年2月19日 下午4:56:07 
 * @version: V1.0   
 */
package src.current.thread.mimaxueyuan.demo.base;


/**
 * 锁重入01
  * @author: Kevin
 * @官网: 	www.mimaxueyuan.com
 * @Q Q群:	660567408
 * @Email:	mimaxueyuan@163.com
 * [每天进步一点点、人生带来大改变...]
 * [本代码对应视频地址:http://study.163.com/course/introduction/1004176043.htm]
 */
public class DemoThread05{
	
	public synchronized void run1(){
		System.out.println(Thread.currentThread().getName()+">run1...");
		//调用同类中的synchronized方法不会引起死锁
		run2();
	}
	
	public synchronized void run2(){
		System.out.println(Thread.currentThread().getName()+">run2...");
	}
	
	public static void main(String[] args) {
		final DemoThread05 demoThread05 = new DemoThread05();
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				demoThread05.run1();
			}
		});
		thread.start();
	}
}
