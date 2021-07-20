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

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * BlockingQueue的实现类之LinkedBlockingDeque 
 * 基于链表的阻塞队列,内部维护一个链表存储缓存数据
 * 内部采用读写分离的锁机制,所以支持写入和读取的并发操作
 *  创建时可指定长度也可以不指定，不指定时代表无界队列 
 *  不允许null值
 * --------------------------------------------------- 
 * offer 如果队列已经满了,则不阻塞，不抛出异常
 * offer 可设置最大阻塞时间,2秒,如果队列还是满的,则不阻塞，不抛出异常 
 * add 如果队列满了，则不阻塞，直接抛出异常 
 * put 如果队列满了,则永远阻塞, 不抛出异常 
 * --------------------------------------------------- 
 * peek 读取头元素不移除，队列为空,返回null,不阻塞, 不抛异常
 * poll 读取头元素并移除，队列为空,返回null,不阻塞, 不抛异常 
 * poll 可指定阻塞时间,2秒,如果队列依然为空,则返回null,不抛异常 
 * take 读取头元素并移除,如果队列为空,则永远阻塞,不抛出异常
 * drainTo 取出queue中指定个数（或全部）的元素放入list中,并移除，当队列为空时不抛出异常
 * 
 * @author: Kevin
 * @官网: 	www.mimaxueyuan.com
 * @Q Q群:	660567408
 * @Email:	mimaxueyuan@163.com
 * @每天进步一点点、人生带来大改变...
 * @本代码对应视频地址:http://study.163.com/course/introduction/1004176043.htm
 */
public class DemoThread31 {

	// 测试各种添加元素的方法
	public static void testAdd() {
		LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>(3);
		queue.add(1);
		queue.offer(2);
		//queue.add(null); //不允许添加null元素
		try {
			queue.put(3);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		System.out.println("1>>"+queue);
		queue.offer(4); // 如果队列已经满了,则不阻塞，不抛出异常
		System.out.println("2>>"+queue);
		try {
			// 可设置最大阻塞时间,2秒,如果队列还是满的,则不阻塞，不抛出异常
			queue.offer(6, 2, TimeUnit.SECONDS);
			System.out.println("3>>"+queue);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		queue.add(7); //如果队列满了，则不阻塞，直接抛出异常
		// System.out.println(queue);

		try {
			queue.put(7); // 如果队列满了,则永远阻塞, 不抛出异常
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("4>>"+queue);

	}

	// 测试获取数据1
	public static void testTake1() {
		LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>(2);
		queue.add(1);
		queue.add(2);

		System.out.println("1>>"+queue.peek()); // 读取头元素不移除
		System.out.println("2>>"+queue);

		System.out.println("3>>"+queue.poll()); // 读取头元素，并移除
		System.out.println("4>>"+queue);

		try {
			// 获取头元素,并移除数据
			System.out.println("5>>"+queue.take());
			System.out.println("6>>"+queue);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		System.out.println("7>>"+queue.peek()); // 队列为空,返回null,不阻塞, 不抛异常
		System.out.println("8>>"+queue.poll()); // 队列为空,返回null,不阻塞, 不抛异常

		try {
			// 可指定阻塞时间,2秒,如果队列依然为空,则返回null,不抛异常
			System.out.println("9>>"+queue.poll(2, TimeUnit.SECONDS));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		try {
			queue.take(); // 如果队列为空,则永远阻塞,不抛出异常
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 测试获取数据2
	public static void testTake2() {
		LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>();
		queue.add(1);
		queue.add(2);
		queue.add(3);

		ArrayList<Integer> list = new ArrayList<Integer>();
		queue.drainTo(list, 2); //取出queue中指定个数的元素放入list中,并移除
		System.out.println(list);
		System.out.println(queue);
	}

	// 测试获取数据3
	public static void testTake3() {
		LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>(3);
		queue.add(1);
		queue.add(2);
		queue.add(3);

		ArrayList<Integer> list = new ArrayList<Integer>();
		queue.drainTo(list); //取出queue中的全部元素放入list中,并移除
		System.out.println(list);
		System.out.println(queue);
		
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		queue.drainTo(list1); //当队列为空时不抛出异常
		System.out.println(list1);
		System.out.println(queue);
	}

	public static void main(String[] args) {
//		 testAdd();
//		 testTake1();
//		 testTake2();
		 testTake3();
	}
}
