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
 * 同步代码块
 * (当前对象、类、任意对象)
 * (同类型锁之间互斥,不同类型的锁之间互不干扰)
  * @author: Kevin
 * @官网: 	www.mimaxueyuan.com
 * @Q Q群:	660567408
 * @Email:	mimaxueyuan@163.com
 * [每天进步一点点、人生带来大改变...]
 * [本代码对应视频地址:http://study.163.com/course/introduction/1004176043.htm]
 */
public class DemoThread08 {

	public void run1() {
		synchronized (this) {
			try {
				System.out.println(Thread.currentThread().getName()+">当前对象锁..");
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void run2() {
		synchronized (DemoThread08.class) {
			try {
				System.out.println(Thread.currentThread().getName()+">类锁..");
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private Object objectLock = new Object();
	public void run3() {
		synchronized (objectLock) {
			try {
				System.out.println(Thread.currentThread().getName()+">任意对象锁..");
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	//测试方法
	public static void test(final int type){
		if(type==1){
			System.out.println("当前对象锁测试...");
		}else if(type==2){
			System.out.println("类锁测试...");
		}else{
			System.out.println("任意对象锁测试...");
		}
		final DemoThread08 demo1 = new DemoThread08();
		final DemoThread08 demo2 = new DemoThread08();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				if(type==1){
					demo1.run1();	
				}else if(type==2){
					demo1.run2();
				}else{
					demo1.run3();
				}
			}
		},"t1");
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				if(type==1){
					demo1.run1();	
				}else if(type==2){
					demo2.run2();
				}else{
					demo1.run3();
				}
			}
		},"t2");
		t1.start();
		t2.start();
	}
	
	public static void main(String[] args) {
//		test(1);
//		test(2);
//		test(3);
		
		final DemoThread08 demo1 = new DemoThread08();
		final DemoThread08 demo2 = new DemoThread08();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				demo1.run2();	
			}
		},"t1");
		t1.start();
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				demo2.run1();	
			}
		},"t2");
		t2.start();
	}
}
