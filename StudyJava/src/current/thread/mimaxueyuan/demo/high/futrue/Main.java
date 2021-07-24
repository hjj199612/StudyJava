package current.thread.mimaxueyuan.demo.high.futrue;

/**
 * 
* @author: Kevin
 * @官网: 	www.mimaxueyuan.com
 * @Q Q群:	660567408
 * @Email:	mimaxueyuan@163.com
 * [每天进步一点点、人生带来大改变...]
 * [本代码对应视频地址:http://study.163.com/course/introduction/1004176043.htm]
 */
public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		//1.客户端发送请求,此处的客户端就是Main方法
		FutureController fc = new FutureController();
		//2.服务端的Controller.handler方法被调用,并传入了参数
		//3.此处返回的Data对象为FutureData对象,返回的是Data的代理类
		FutureData data = fc.handler("UserId");
		System.out.println("请求发送成功...");
		System.out.println("继续其他的处理...");
		
		//3.获取真实数据
		System.out.println("Main开始获取真实结果");
		String result = data.getRealData();
		System.out.println(result);
	}
}
