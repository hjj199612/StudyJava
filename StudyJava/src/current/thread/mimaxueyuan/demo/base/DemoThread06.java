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
 * 锁重入02 
 * (父子类可以锁重入)
 * @author: Kevin
 * @官网: 	www.mimaxueyuan.com
 * @Q Q群:	660567408
 * @Email:	mimaxueyuan@163.com
 * [每天进步一点点、人生带来大改变...]
 * [本代码对应视频地址:http://study.163.com/course/introduction/1004176043.htm]
 */
public class DemoThread06 {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				Child sub = new Child();
				sub.runChild();
			}
		});
		t1.start();
	}
}

class Parent {
	public int i = 10;
	public synchronized void runParent() {
		try {
			i--;
			System.out.println("Parent>>>>i=" + i);
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Child extends Parent {
	
	public synchronized void runChild() {
		try {
			while (i > 0) {
				i--;
				System.out.println("Child>>>>i=" + i);
				Thread.sleep(100);
				//调用父类中的synchronized方法不会引起死锁
				this.runParent();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
