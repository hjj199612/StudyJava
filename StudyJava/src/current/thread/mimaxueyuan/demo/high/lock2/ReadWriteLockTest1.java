package current.thread.mimaxueyuan.demo.high.lock2;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/**
* @author: Kevin
* @官网: 	www.mimaxueyuan.com
* @Q Q群:	660567408
* @Email:	mimaxueyuan@163.com
* [每天进步一点点、人生带来大改变...]
* [本代码对应视频地址:http://study.163.com/course/introduction/1004176043.htm]
*/
public class ReadWriteLockTest1 {

	private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
	private ReadLock readLock = rwLock.readLock();
	private WriteLock writeLock = rwLock.writeLock();

	public void read() {
		try {
			readLock.lock();
			System.out.println("当前线程:" + Thread.currentThread().getName() + "read进入...");
			Thread.sleep(3000);
			System.out.println("当前线程:" + Thread.currentThread().getName() + "read退出...");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			readLock.unlock();
		}
	}

	public void write() {
		try {
			writeLock.lock();
			System.out.println("当前线程:" + Thread.currentThread().getName() + "write进入...");
			Thread.sleep(3000);
			System.out.println("当前线程:" + Thread.currentThread().getName() + "write退出...");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			writeLock.unlock();
		}
	}

	public static void main(String[] args) {

		final ReadWriteLockTest1 urrw = new ReadWriteLockTest1();

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				urrw.read();
			}
		}, "t1");
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				urrw.read();
			}
		}, "t2");
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				urrw.write();
			}
		}, "t3");
		Thread t4 = new Thread(new Runnable() {
			@Override
			public void run() {
				urrw.write();
			}
		}, "t4");

//		t1.start(); // Read
//		t2.start(); // Read

//		 t1.start(); // Read
//		 t3.start(); // Write

		 t3.start(); //write
		 t4.start(); //write
	}
}
