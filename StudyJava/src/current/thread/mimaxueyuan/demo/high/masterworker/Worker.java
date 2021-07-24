package current.thread.mimaxueyuan.demo.high.masterworker;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Worker
 * 具体的任务处理类
 * 不断的从队列中获取任务->处理->保存结果
 * 
*
* @author: Kevin
* @官网: 	www.mimaxueyuan.com
* @Q Q群:	660567408
* @Email:	mimaxueyuan@163.com
* [每天进步一点点、人生带来大改变...]
* [本代码对应视频地址:http://study.163.com/course/introduction/1004176043.htm]
*/
public class Worker implements Runnable {

	//存放任务的队列引用
	private ConcurrentLinkedQueue<Task> taskQueue;
	//存放Worker处理结果的Map
	private ConcurrentHashMap<String, Object> taskResultMap;
	
	public void setWorkQueue(ConcurrentLinkedQueue<Task> workQueue) {
		this.taskQueue = workQueue;
	}

	public void setTaskResultMap(ConcurrentHashMap<String, Object> resultMap) {
		this.taskResultMap = resultMap;
	}
	
	@Override
	public void run() {
		while(true){
			//取出一个任务队列中的任务
			Task task = this.taskQueue.poll();
			if(task == null){
				//如果没有任务了则退出
				break;
			}
			System.out.println("Worker-"+Thread.currentThread()+"-执行任务"+task.getId());
			//调用任务处理
			Object output = handle(task);
			this.taskResultMap.put(Integer.toString(task.getId()), output);
		}
	}

	//任务处理方法
	private Object handle(Task input) {
		Object output = null;
		try {
			//模拟任务处理的耗时
			Thread.sleep(500);
			output = input.getPrice()+1;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return output;
	}

}
