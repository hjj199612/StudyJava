package src.current.thread.mimaxueyuan.demo.high.mq;

/**
 * 数据实体
 * 模拟生产者产生的数据实体
 * @author: Kevin
 * @官网: 	www.mimaxueyuan.com
 * @Q Q群:	660567408
 * @Email:	mimaxueyuan@163.com
 * @每天进步一点点、人生带来大改变...
 * @本代码对应视频地址:http://study.163.com/course/introduction/1004176043.htm
 */
public final class Data {

	private String id;
	private String name;
	
	public Data(String id, String name){
		this.id = id;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString(){
		return "{id: " + id + ", name: " + name + "}";
	}
	
}
