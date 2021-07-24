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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 古老的并发容器构建
 * 
 * @author: Kevin
 * @官网: 	www.mimaxueyuan.com
 * @Q Q群:	660567408
 * @Email:	mimaxueyuan@163.com
 * @每天进步一点点、人生带来大改变...
 * @本代码对应视频地址:http://study.163.com/course/introduction/1004176043.htm
 */
public class DemoThread26 {
	public static void main(String[] args) throws Exception {
		/*
		 * 使用以下方法被包裹的类将支持多线程 
		 * Collections.synchronizedCollection(c);
		 * Collections.synchronizedList(list); 
		 * Collections.synchronizedMap(m);
		 * Collections.synchronizedSet(s); 
		 * Collections.synchronizedSortedMap(m);
		 * Collections.synchronizedSortedSet(s);
		 */
		
		// 非线程安全的List
		//final List<String> list = new ArrayList<String>(1);
		// 线程安全的List
		final List<String> list = Collections.synchronizedList(new ArrayList<String>());
		ExecutorService es = Executors.newFixedThreadPool(100);

		//向list中并发加入1万个元素,如果是线程安全的那么list.size=1万,否则!=1万
		for (int i = 0; i < 10000; i++) {
			es.execute(new Runnable() {
				@Override
				public void run() {
					list.add("5");
				}
			});
		}

		es.shutdown();

		while (true) {
			if (es.isTerminated()) {
				System.out.println("所有的子线程都结束了！");
				System.out.println(list.size());
				if(list.size()!=10000){
					System.out.println("线程不安全！");
				}else{
					System.out.println("线程安全!");
				}
				break;
			}
		}
	}
}
