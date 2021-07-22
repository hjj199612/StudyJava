/**   
 * 
 * @Title: DemoThread09.java 
 * @Prject: DemoThread
 * @Package: com.liang.demo 
 * @author: yin.hl
 * @date: 2017年3月20日 下午10:55:51 
 * @version: V1.0   
 */
package src.current.thread.mimaxueyuan.demo.middle;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 阻塞队列之DelayQueue（带有延迟功能的阻塞队列）
 * 
 * Delayed 元素的一个无界阻塞队列，只有在延迟期满时才能从中提取元素。该队列的头部 是延迟期满后保存时间最长的 Delayed 元素。
 * 如果延迟都还没有期满，则队列没有头部，并且 poll 将返回 null。
 * 当一个元素的 getDelay(TimeUnit.NANOSECONDS) 方法返回一个小于等于 0 的值时，将发生到期。
 * 即使无法使用 take 或 poll 移除未到期的元素，也不会将这些元素作为正常元素对待。
 * 例如，size 方法同时返回到期和未到期元素的计数。此队列不允许使用 null 元素。
 * 内部元素需实现Delayed接口
 * ----------------------------------------------
 * Demo说明：模拟一种游戏的自动退出机制，例如甲乙丙三个人分别可以免费玩游戏3、2、1秒,到时自动踢出系统
 * ----------------------------------------------
 * ----------------------------------------------
 * 
 * @author: Kevin
 * @官网: 	www.mimaxueyuan.com
 * @Q Q群:	660567408
 * @Email:	mimaxueyuan@163.com
 * @每天进步一点点、人生带来大改变...
 * @本代码对应视频地址:http://study.163.com/course/introduction/1004176043.htm
 */
class User implements Delayed{

	private int id; 
	private String name;
	private long endTime; //退出时间
	
	public User(int id, String name, long endTime) {
		this.id = id;
		this.name = name;
		this.endTime = endTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getEndTime() {
		return endTime;
	}
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
	@Override
	public String toString() {
		return this.name;
	}
	
	//由于需要根据延时时间的长短,计算从数据中移除的顺序，所以需要实现compareTo方法计算优先级，类似优先级队列
	@Override
	public int compareTo(Delayed o) {
		User user = (User)o;
		if(this.endTime>user.getEndTime()){
			return 1;
		}else if(this.endTime<user.getEndTime()){
			return -1;
		}else{
			return 0;
		}
	}

	//计算剩余延迟时间；零或负值指示延迟时间已经用尽
	@Override
	public long getDelay(TimeUnit unit) {
		return this.endTime-System.currentTimeMillis();
	}
	
}

public class DemoThread34 {
	
	DelayQueue<User> delayQueue = new DelayQueue<User>();
	
	//登录游戏,加入队列
	public void login(User user){
		delayQueue.add(user);
		System.out.println("用户("+user.getId()+")"+user.getName()+"已登录,预计下机时间为"+user.getEndTime());
	}
	
	//退出游戏,移除队列
	public void logout(){
		try {
			System.out.println(delayQueue);
			User user = delayQueue.take();
			//User user = delayQueue.poll(); //不能使用poll方法,因为没有阻塞功能
			System.out.println("用户("+user.getId()+")"+user.getName()+"到时自动退出,时间为"+System.currentTimeMillis()+"...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//获取当前在线人数
	public int onlineSize(){
		return delayQueue.size();
	}
	
	public static void main(String[] args) {
		DemoThread34 demo = new DemoThread34();
		
		//用户登录,并设置退出时间
		demo.login(new User(1,"甲",30000+System.currentTimeMillis()));
		demo.login(new User(2,"乙",20000+System.currentTimeMillis()));
		demo.login(new User(3,"丙",10000+System.currentTimeMillis()));
		
		while(true){
			//监控到时用户
			demo.logout();
			//如果在线用户则退出
			if(demo.onlineSize()==0){
				break;
			}
		}
		
	}
}
