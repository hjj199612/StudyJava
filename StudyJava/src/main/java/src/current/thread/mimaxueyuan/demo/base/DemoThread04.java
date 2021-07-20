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
 * 脏读
  * @author: Kevin
 * @官网: 	www.mimaxueyuan.com
 * @Q Q群:	660567408
 * @Email:	mimaxueyuan@163.com
 * [每天进步一点点、人生带来大改变...]
 * [本代码对应视频地址:http://study.163.com/course/introduction/1004176043.htm]
 */
public class DemoThread04 {

	private String name = "张三";
	private String address = "大兴";

	public synchronized void setVal(String name, String address) {
		this.name = name;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.address = address;
		System.out.println("setValue最终结果：username = " + name + " , address = " + address);
	}

	public synchronized void getVal() {
		System.out.println("getValue方法得到：username = " + this.name + " , address = " + this.address);
	}

	public static void main(String[] args) throws Exception {

		final DemoThread04 dr = new DemoThread04();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				dr.setVal("李四", "昌平");
			}
		});
		t1.start();
		
		Thread.sleep(1000);

		dr.getVal();
	}

}
