package current.thread.mimaxueyuan.demo.high.futrue;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
* @author: Kevin
* @官网: 	www.mimaxueyuan.com
* @Q Q群:	660567408
* @Email:	mimaxueyuan@163.com
* [每天进步一点点、人生带来大改变...]
* [本代码对应视频地址:http://study.163.com/course/introduction/1004176043.htm]
*/
public class JdkFuture implements Callable<String>{
	private String para;
	
	public JdkFuture(String para){
		this.para = para;
	}
	
	/**
	 * 这里是真实的业务逻辑，其执行可能很慢
	 */
	@Override
	public String call() throws Exception {
		//模拟执行耗时
		Thread.sleep(5000);
		String result = this.para + "处理完成";
		return result;
	}
	
	//主控制函数
	public static void main(String[] args) throws Exception {
		String queryStr = "zhangsan";
		
		//构造FutureTask，并且传入需要真正进行业务逻辑处理的类,该类一定是实现了Callable接口的类
		FutureTask<String> future = new FutureTask<String>(new JdkFuture(queryStr));
		FutureTask<String> future2 = new FutureTask<String>(new JdkFuture(queryStr));
		
		//创建一个固定线程的线程池且线程数为1,
		ExecutorService executor = Executors.newFixedThreadPool(2);
		//这里提交任务future,则开启线程执行RealData的call()方法执行
		//submit和execute的区别： 第一点是submit可以传入实现Callable接口的实例对象， 第二点是submit方法有返回值
		
		Future f1 = executor.submit(future);		//单独启动一个线程去执行的
		Future f2 = executor.submit(future2);
		System.out.println("请求完毕");
		
		try {
			//这里可以做额外的数据操作，也就是主程序执行其他业务逻辑
			System.out.println("处理实际的业务逻辑...");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//调用获取数据方法,如果call()方法没有执行完成,则依然会进行等待
		System.out.println("数据：" + future.get());
		System.out.println("数据：" + future2.get());
		
		executor.shutdown();
	}

}
