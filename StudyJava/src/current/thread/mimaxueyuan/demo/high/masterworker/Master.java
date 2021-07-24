package current.thread.mimaxueyuan.demo.high.masterworker;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Master
 * 接收Client提交过来的任务
 * 创建Worker
 * 运行Worker
 * 汇总Task的处理结果
 *
**
* @author: Kevin
* @官网: 	www.mimaxueyuan.com
* @Q Q群:	660567408
* @Email:	mimaxueyuan@163.com
* [每天进步一点点、人生带来大改变...]
* [本代码对应视频地址:http://study.163.com/course/introduction/1004176043.htm]
*/
public class Master {

	//存放任务的队列
	private ConcurrentLinkedQueue<Task> taskQueue = new ConcurrentLinkedQueue<Task>();
	
	//存放Worker的Map
	private HashMap<String, Thread> workers = new HashMap<String, Thread>();
	
	//存放每一个Worker的处理结果
	private ConcurrentHashMap<String, Object> taskResultMap = new ConcurrentHashMap<String, Object>();
	
	/**
	 * 构造函数
	 * @Title:Master
	 * @param worker worker处理类
	 * @param workerCount worker的数量
	 */
	public Master(Worker worker , int workerCount){
		worker.setWorkQueue(this.taskQueue);
		worker.setTaskResultMap(this.taskResultMap);
		//将Worker放入容器
		for(int i = 0; i < workerCount; i ++){
			this.workers.put(Integer.toString(i), new Thread(worker));
		}
	}
	
	//需要一个提交任务,就是讲任务放入队列中
	public void submit(Task task){
		this.taskQueue.add(task);
	}
	
	//执行方,启动所有的worker方法去执行任务
	public void execute(){
		for(Map.Entry<String, Thread> me : workers.entrySet()){
			me.getValue().start();
		}
	}

	//判断是否运行结束的方法
	public boolean isComplete() {
		for(Map.Entry<String, Thread> me : workers.entrySet()){
			if(me.getValue().getState() != Thread.State.TERMINATED){
				return false;
			}
		}		
		return true;
	}

	//汇总每个Task的结果
	public int getResult() {
		int priceResult = 0;
		for(Map.Entry<String, Object> me : taskResultMap.entrySet()){
			priceResult += (Integer)me.getValue();
		}
		return priceResult;
	}
	
}
