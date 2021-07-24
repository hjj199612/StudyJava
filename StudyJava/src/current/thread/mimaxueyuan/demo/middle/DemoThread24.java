/**   
 * 
 * @Title: DemoThread09.java 
 * @Prject: DemoThread
 * @Package: com.liang.demo 
 * @author: yin.hl
 * @date: 2017年3月20日 下午10:55:51 
 * @version: V1.0   
 */
package current.thread.mimaxueyuan.demo.middle;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 饿汉模式-单例对象构建方法
 * (可以解决内存开销的问题,但是不当的写法可能引起线程安全问题)
 * @author: Kevin
 * @官网: 	www.mimaxueyuan.com
 * @Q Q群:	660567408
 * @Email:	mimaxueyuan@163.com
 * @每天进步一点点、人生带来大改变...
 * @本代码对应视频地址:http://study.163.com/course/introduction/1004176043.htm
 */
class Singleton3 {
	private static Singleton3 singleton = null; // 不建立对象
	private Singleton3() {
	}
	/*synchronized 代码块进行双重检查,可以提高性能*/
	public static Singleton3 getInstance() {
		if (singleton == null) { // 先判断是否为空
			synchronized (Singleton3.class) {
				//此处必须进行双重判断,否则依然存在线程安全问题
				if(singleton == null){
					try {
						Thread.sleep(1000);
						System.out.println("构建这个对象可能耗时很长...");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					singleton = new Singleton3(); // 懒汉式做法
				}
			}
		}
		return singleton;
	}
	
	@Override
	public String toString() {
		return ""+this.hashCode();
	}
}

public class DemoThread24 {
	public static void main(String[] args) throws InterruptedException {

		ExecutorService es = Executors.newFixedThreadPool(100);

		for (int i = 0; i < 10; i++) {
			es.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println(Singleton3.getInstance());
				}
			});
		}

		es.shutdown();
	}
}
