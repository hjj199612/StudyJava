/**   
 * 
 * @Title: FutureDemo.java 
 * @Prject: DemoThread
 * @Package: com.liang.demo.high.futrue 
 * @author: yin.hl
 * @date: 2017年3月26日 下午9:12:26 
 * @version: V1.0   
 */
package src.current.thread.mimaxueyuan.demo.high.futrue;


/** 
 * 接收请求的控制器(例如接收PC端请求)
 * 
* @author: Kevin
 * @官网: 	www.mimaxueyuan.com
 * @Q Q群:	660567408
 * @Email:	mimaxueyuan@163.com
 * [每天进步一点点、人生带来大改变...]
 * [本代码对应视频地址:http://study.163.com/course/introduction/1004176043.htm]
 */
public class FutureController {

	public FutureData handler(final String param){
		//由于真实的数据还没有准备好,所以返回一个真实Data数据的代理类
		final FutureData futureData = new FutureData();
		
		//2 启动一个新的线程，去加载真实的数据，传递给这个代理对象
		new Thread(new Runnable() {
			@Override
			public void run() {
				futureData.initRealData(param);
			}
		}).start();
		
		return futureData;
	}
}
