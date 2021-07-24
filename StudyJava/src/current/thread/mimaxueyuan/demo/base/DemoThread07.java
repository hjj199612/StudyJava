/**   
 * 
 * @Title: DemoThread03.java 
 * @Prject: DemoThread
 * @Package: com.liang.demo 
 * @author: yin.hl
 * @date: 2017年2月19日 下午4:56:07 
 * @version: V1.0   
 */
package current.thread.mimaxueyuan.demo.base;



/**
 * 抛出异常释放锁
 * @author: Kevin
 * @官网: 	www.mimaxueyuan.com
 * @Q Q群:	660567408
 * @Email:	mimaxueyuan@163.com
 * [每天进步一点点、人生带来大改变...]
 * [本代码对应视频地址:http://study.163.com/course/introduction/1004176043.htm]
 */
public class DemoThread07 {
	
	private int i = 0;
	
	public synchronized void run(){
		while(true){
			i++;
			System.out.println(Thread.currentThread().getName()+"-run>i="+i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			int k = 10/0;
			
			if (i == 10) {
				throw new RuntimeException();
			}
		}
	}
	
	public synchronized void get(){
		System.out.println(Thread.currentThread().getName()+"-get>i="+i);
	}
	
	public static void main(String[] args) throws InterruptedException {
		final DemoThread07 demoThread07 = new DemoThread07();
		new Thread(new Runnable() {
			@Override
			public void run() {
				demoThread07.run();
			}
		},"t1").start();
		
		//保证t1线程先执行
		Thread.sleep(1000);
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				demoThread07.get();
			}
		},"t2").start();
	}
}
