package designpattern.annotaionProxy;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hjj199612
 * @date 2021/7/18 3:41 下午
 * @description
 */
public class IOCFactory {

    private static Map<String, Object> ioc;

    public static <T> T getObject(String name, Class<T> c) {
        Object bean = ioc.get(name);
        if (bean == null) {
            throw new RuntimeException("未找到Bean名：" + name);
        }
//        if (bean.getClass() != c) {
//            throw new RuntimeException("Bean名：" + name + "不是类型：" + c);
//        }
        return (T) bean;
    }

    static {
        //springboot通过指定扫描路径发现Bean，这里不扫描了，直接初始化ioc容器
        ioc = new HashMap<>();

        Bank atm = new ATM();
        atm = (Bank) Proxy.newProxyInstance(atm.getClass().getClassLoader(),
                atm.getClass().getInterfaces(), new TransactionHandler(atm));
        ioc.put("ATM", atm);

        Bank employee = new Employee();
        employee = (Bank) Proxy.newProxyInstance(employee.getClass().getClassLoader(),
                employee.getClass().getInterfaces(), new TransactionHandler(employee));
        ioc.put("Employee", employee);


    }


}
