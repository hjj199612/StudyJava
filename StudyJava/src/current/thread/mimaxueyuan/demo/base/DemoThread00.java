package current.thread.mimaxueyuan.demo.base;

/**
 * @author: Kevin
 * @官网: 	www.mimaxueyuan.com
 * @Q Q群:	660567408
 * @Email:	mimaxueyuan@163.com
 * [每天进步一点点、人生带来大改变...]
 * [本代码对应视频地址:http://study.163.com/course/introduction/1004176043.htm]
 */
class User {
	private String name;
	private String pass;

	public User(String name, String pass) {
		this.name = name;
		this.pass = pass;
	}

	public synchronized void set(String name, String pass) {
		this.name = name;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.pass = pass;
		System.out.println(Thread.currentThread().getName() + "-name=" + this.name + "pass=" + this.pass);
	}
}

/**
 * serlet是单例多线程的、Servlet的本身实现并不是一个单例实现、只是容器加载的时候只实例化一次，所造成的单例现象
 *
 * @ClassName: UserServlet 
 * @author: yin.hl
 * @date: 2017年6月4日 上午9:04:24
 */
class UserServlet {

	private User user;

	public UserServlet() {
		user = new User("张三", "123456");
	}

	public void setPass(String name, String pass) {
		user.set(name, pass);
	}
}

/**
 * 
 * 
 * @ClassName: DemoThread00
 * @author: yin.hl
 * @date: 2017年2月19日 下午4:56:07
 */
public class DemoThread00 {
	
	public static void main(String[] args) {

		final UserServlet us = new UserServlet();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				us.setPass("李四", "777777");
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				us.setPass("王五", "888888");
			}
		}).start();
	}
}