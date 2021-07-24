package current.thread.mimaxueyuan.demo.high.executors;

import java.util.concurrent.Callable;
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
public class CachedThreadPoolTest {

	public static void main(String[] args) {
		//core 核心线程数
		//max  最大线程数
		//timeout 超时时间
		//queue	等待队列
		
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			final int index = i;
			/*try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
			Runnable task = new Runnable() {
				public void run() {
					try {
						Thread.sleep(index*1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+">>"+index);
				}
			};
			cachedThreadPool.execute(task);
		}
	}

}

class Task implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
	}
}

class Caller implements Callable<String>{
	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
