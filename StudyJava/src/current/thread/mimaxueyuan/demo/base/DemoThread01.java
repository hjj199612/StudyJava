/**   
 * 
 * @Title: DemoThread01.java 
 * @Prject: DemoThread
 * @Package: com.liang.demo 
 * @author: yin.hl
 * @date: 2017年2月19日 下午4:56:07 
 * @version: V1.0   
 */
package current.thread.mimaxueyuan.demo.base;

/**
 * 什么是线程安全 (一个对象一把锁)
 * 
 * 实现线程类的两种方式:
 * 继承Thread会影响继承其他类
 * 实现Runnable接口、没有start方法、需要借助Thread类执行、实际调用native start0方法
 * 
 * @author: Kevin
 * @官网: 	www.mimaxueyuan.com
 * @Q Q群:	660567408
 * @Email:	mimaxueyuan@163.com
 * [每天进步一点点、人生带来大改变...]
 * [本代码对应视频地址:http://study.163.com/course/introduction/1004176043.htm]
 */
public class DemoThread01 implements Runnable {

	private int count = 0;

	@Override
	// 线程不安全
	//public void run() {
	// 线程安全
	public synchronized void run() {
		count++;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + ">count=" + count);
	}

	public static void main(String[] args) {
		/**
		 * Synchronized的作用是加锁，所有的synchronized方法都会顺序执行，（这里只占用CPU的顺序）。
		 * Synchronized方法执行方式： 首先尝试获得锁 如果获得锁，则执行Synchronized的方法体内容。
		 * 如果无法获得锁则等待，并且不断的尝试去获得锁，一旦锁被释放，则多个线程会同时去尝试获得所，造成锁竞争问题。
		 * 锁竞争问题，在高并发、线程数量高时会引起CPU占用居高不下，或者直接宕机。
		 */
		DemoThread01 thread = new DemoThread01();
		for (int i = 0; i < 100; i++) {
			new Thread(thread,"t"+i).start();
		}
		
	}
}