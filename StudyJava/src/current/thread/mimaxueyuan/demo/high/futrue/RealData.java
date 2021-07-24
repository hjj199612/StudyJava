/**   
 * 
 * @Title: RealResult.java 
 * @Prject: DemoThread
 * @Package: com.liang.demo.high.futrue 
 * @author: yin.hl
 * @date: 2017年3月26日 下午9:09:52 
 * @version: V1.0   
 */
package current.thread.mimaxueyuan.demo.high.futrue;

/**
 * 真实数据（用户真实想得到的数据从这里获取)
 *
 * @author: Kevin
 * @官网: 	www.mimaxueyuan.com
 * @Q Q群:	660567408
 * @Email:	mimaxueyuan@163.com
 * [每天进步一点点、人生带来大改变...]
 * [本代码对应视频地址:http://study.163.com/course/introduction/1004176043.htm]
 */
public class RealData implements Data {

	private String result;

	@Override
	public String getRealData() {
		return result;
	}

	//根据参数初始化数据
	public RealData initRealData(String param) {
		System.out.println("根据" + param + "进行查询，这是一个很耗时的操作..");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("操作完毕，获取结果");
		result = "查询结果";
		return this;
	}

}
