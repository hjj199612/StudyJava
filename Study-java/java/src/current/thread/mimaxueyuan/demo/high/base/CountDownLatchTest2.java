package src.current.thread.mimaxueyuan.demo.high.base;

import java.util.concurrent.CountDownLatch;

/**
 * @author: Kevin
 * @官网: 	www.mimaxueyuan.com
 * @Q Q群:	660567408
 * @Email:	mimaxueyuan@163.com
 * [每天进步一点点、人生带来大改变...]
 * [本代码对应视频地址:http://study.163.com/course/introduction/1004176043.htm]
 */
public class CountDownLatchTest2 {

	public static void main(String[] args) {

		final CountDownLatch countDownLatch2 = new CountDownLatch(2);
		final CountDownLatch countDownLatch3 = new CountDownLatch(3);

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("t2 start, waitting for countDownLatch2 to zero");
					countDownLatch2.await();
					System.out.println("t2 stop");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "t2").start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("t3 start, waitting for countDownLatch3 to zero");
					countDownLatch3.await();
					System.out.println("t3 stop");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "t3").start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
					System.out.println("countDownLatch3 count down1");
					countDownLatch3.countDown();
					Thread.sleep(1000);
					System.out.println("countDownLatch2 count down1");
					countDownLatch2.countDown();
					Thread.sleep(1000);
					System.out.println("countDownLatch3 count down2");
					countDownLatch3.countDown();
					Thread.sleep(1000);
					System.out.println("countDownLatch2 count down2");
					countDownLatch2.countDown();
					Thread.sleep(1000);
					System.out.println("countDownLatch3 count down3");
					countDownLatch3.countDown();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, "t1").start();

	}

}
