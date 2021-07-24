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
 * (类加载的时候，就进行对象的创建，系统开销较大，影响性能，所以多数采用饿汉模式，在使用时才真正的创建单例对象)
 * @author: Kevin
 * @官网: 	www.mimaxueyuan.com
 * @Q Q群:	660567408
 * @Email:	mimaxueyuan@163.com
 * @每天进步一点点、人生带来大改变...
 * @本代码对应视频地址:http://study.163.com/course/introduction/1004176043.htm
 */
class Singleton1 {
	private static Singleton1 singleton = new Singleton1(); // 建立对象
	private Singleton1() {
		try {
			Thread.sleep(1000);
			System.out.println("构建这个对象可能耗时很长...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static Singleton1 getInstance() {
		return singleton;// 直接返回单例对象
	}
	@Override
	public String toString() {
		return ""+this.hashCode();
	}
}

public class DemoThread22 {
	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService es = Executors.newFixedThreadPool(10);
		
		for(int i=0;i<10;i++){
			es.execute(new Runnable() {
				@Override
				public void run() {
					Singleton1 instance = Singleton1.getInstance();
					System.out.println(instance);
				}
			});
		}
		
		es.shutdown();
	}
}
