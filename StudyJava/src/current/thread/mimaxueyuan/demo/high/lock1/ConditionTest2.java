package current.thread.mimaxueyuan.demo.high.lock1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
* @author: Kevin
* @官网: 	www.mimaxueyuan.com
* @Q Q群:	660567408
* @Email:	mimaxueyuan@163.com
* [每天进步一点点、人生带来大改变...]
* [本代码对应视频地址:http://study.163.com/course/introduction/1004176043.htm]
*/
public class ConditionTest2 {

	private ReentrantLock lock = new ReentrantLock();
	private Condition c1 = lock.newCondition();
	private Condition c2 = lock.newCondition();
	
	public void run1(){
		try {
			lock.lock();
			System.out.println("当前线程：" +Thread.currentThread().getName() + "进入方法run1等待..");
			c1.await();
			System.out.println("当前线程：" +Thread.currentThread().getName() + "方法run1继续..");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public void run2(){
		try {
			lock.lock();
			System.out.println("当前线程：" +Thread.currentThread().getName() + "进入方法run2等待..");
			c1.await();
			System.out.println("当前线程：" +Thread.currentThread().getName() + "方法run2继续..");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public void run3(){
		try {
			lock.lock();
			System.out.println("当前线程：" +Thread.currentThread().getName() + "进入方法run3等待..");
			c2.await();
			System.out.println("当前线程：" +Thread.currentThread().getName() + "方法run3继续..");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public void run4(){
		try {
			lock.lock();
			System.out.println("当前线程：" +Thread.currentThread().getName() + "run4唤醒..");
			c1.signalAll(); //object.notifyAll()
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public void run5(){
		try {
			lock.lock();
			System.out.println("当前线程：" +Thread.currentThread().getName() + "run5唤醒..");
			c2.signal();	//object.notify()
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		
		
		final ConditionTest2 umc = new ConditionTest2();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				umc.run1();
			}
		},"t1");
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				umc.run2();
			}
		},"t2");
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				umc.run3();
			}
		},"t3");
		Thread t4 = new Thread(new Runnable() {
			@Override
			public void run() {
				umc.run4();
			}
		},"t4");
		Thread t5 = new Thread(new Runnable() {
			@Override
			public void run() {
				umc.run5();
			}
		},"t5");
		
		t1.start();	// c1
		t2.start();	// c1
		t3.start();	// c2
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		t4.start();	// c1
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t5.start();	// c2
		
	}
	
	
	
}
