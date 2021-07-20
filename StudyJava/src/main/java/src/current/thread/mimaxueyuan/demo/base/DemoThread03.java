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
 * 同步与异步
  * @author: Kevin
 * @官网: 	www.mimaxueyuan.com
 * @Q Q群:	660567408
 * @Email:	mimaxueyuan@163.com
 * [每天进步一点点、人生带来大改变...]
 * [本代码对应视频地址:http://study.163.com/course/introduction/1004176043.htm]
 */
public class DemoThread03{
	
	//同步执行
	public synchronized void print1() {
		System.out.println(Thread.currentThread().getName()+">hello!");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//异步执行
	public void print2() {
		System.out.println(Thread.currentThread().getName()+">hello!");
	}
	
	public static void main(String[] args) {
		
		final DemoThread03 thread = new DemoThread03();
		Thread t1 = new Thread(new Runnable(){
			@Override
			public void run() {
				thread.print1();
			}
		}, "thread1");
		
		Thread t2 = new Thread(new Runnable(){
			@Override
			public void run() {
				thread.print2();
			}
		}, "thread2");
		
		t1.start();
		t2.start();
	}
}
