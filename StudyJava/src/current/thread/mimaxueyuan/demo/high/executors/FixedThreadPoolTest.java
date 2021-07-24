package current.thread.mimaxueyuan.demo.high.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: Kevin
 * @官网: 	www.mimaxueyuan.com
 * @Q Q群:	660567408
 * @Email:	mimaxueyuan@163.com
 * [每天进步一点点、人生带来大改变...]
 * [本代码对应视频地址:http://study.163.com/course/introduction/1004176043.htm]
 */
public class FixedThreadPoolTest {
	public static void main(String[] args) {
		System.out.println(Runtime.getRuntime().availableProcessors());
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(4*20);
		for (int i = 0; i < 10; i++) {
			final int index = i;
			fixedThreadPool.execute(new Runnable() {
				public void run() {
					try {
						System.out.println(Thread.currentThread().getName()+">>"+index);
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
		
		//次方法不阻塞, 调用后不再接收新的任务,所有线程池内任务执行完毕则关闭线程池
//		fixedThreadPool.shutdown();
//		System.out.println("..........分割线.............");
//		fixedThreadPool.execute(new Runnable() {
//			@Override
//			public void run() {
//				System.out.println("run after shutdown.......");
//			}
//		});
		
	}
}
