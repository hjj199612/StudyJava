/**   
 * 
 * @Title: DemoThread09.java 
 * @Prject: DemoThread
 * @Package: com.liang.demo 
 * @author: yin.hl
 * @date: 2017年3月20日 下午10:55:51 
 * @version: V1.0   
 */
package src.current.thread.mimaxueyuan.demo.base;


/**
 * volatile与static不一样,不能相互替代
 * 
 * Static保证唯一性, 不保证一致性，多个实例共享一个静态变量。
 * Volatile保证一致性，不保证唯一性，多个对象有多个volatile变量。
 * 
 * @author: Kevin
 * @官网: 	www.mimaxueyuan.com
 * @Q Q群:	660567408
 * @Email:	mimaxueyuan@163.com
 * [每天进步一点点、人生带来大改变...]
 * [本代码对应视频地址:http://study.163.com/course/introduction/1004176043.htm]
 */
public class DemoThread23 {
	
	public volatile boolean go = true;
	//public static boolean go = true;
	
	public void stop(){
		System.out.println("线程"+Thread.currentThread().getName()+"执行停止操作开始");
		this.go = false;
		System.out.println("线程"+Thread.currentThread().getName()+"执行停止操作结束");
	}
	
	public void run(){
		while(go){
			
		}
		System.out.println("线程"+Thread.currentThread().getName()+"停止");
	}
	
	public void print(){
		System.out.println("go="+go);
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		final DemoThread23 demo = new DemoThread23();
		final DemoThread23 demo2 = new DemoThread23();
		for(int i=0;i<10;i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					demo.run();
				}
			}, "t"+i).start();
		}

		Thread.sleep(2000);
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				//使用demo2进行关闭,发现没有作用
				demo2.stop();
			}
		}, "stop").start();
		
	}
}
