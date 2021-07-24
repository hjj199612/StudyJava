/**   
 * 
 * @Title: DemoThread09.java 
 * @Prject: DemoThread
 * @Package: com.liang.demo 
 * @author: yin.hl
 * @date: 2017年3月20日 下午10:55:51 
 * @version: V1.0   
 */
package current.thread.mimaxueyuan.demo.base;

/**
 * 在线程中修改了锁对象的属性,只要不修改引用则不会产生线程安全问题
 * 
 * @author: Kevin
 * @官网: 	www.mimaxueyuan.com
 * @Q Q群:	660567408
 * @Email:	mimaxueyuan@163.com
 * [每天进步一点点、人生带来大改变...]
 * [本代码对应视频地址:http://study.163.com/course/introduction/1004176043.htm]
 */
class Person {
	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "DemoThread10 [name=" + name + ", age=" + age + "]";
	}
}

public class DemoThread10 {

	private Person person = new Person();

	public void changeUser(String name, int age) {
		synchronized (person) {
			System.out.println("线程" + Thread.currentThread().getName() + "开始" + person);
			// 打开注释：引起对象引用发生变化,t1、t2线程同时进入方法、导致线程安全问题
			//person = new Person();
			person.setAge(age);
			person.setName(name);
			System.out.println("线程" + Thread.currentThread().getName() + "修改为" + person);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("线程" + Thread.currentThread().getName() + "结束" + person);
		}
	}

	public static void main(String[] args) {
		final DemoThread10 thread10 = new DemoThread10();
		new Thread(new Runnable() {
			@Override
			public void run() {
				thread10.changeUser("小白", 99);
			}
		}, "t1").start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				thread10.changeUser("小黑", 100);
			}
		}, "t2").start();
	}
}
