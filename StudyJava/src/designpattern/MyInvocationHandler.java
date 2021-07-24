package designpattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;

/**
 * @Description:
 * @Author: huangjj24
 * @CreateDate: 2021-4-22 14:31
 **/
public class MyInvocationHandler implements InvocationHandler {

    private final Map<String,Object> delegateByMethods;

    private final Class<?>[] interfaces;

    public MyInvocationHandler(Object... objects) {
        Set<Class<?>> set = new HashSet<>();
        delegateByMethods = new HashMap<>();
        for (Object object : objects) {
            Class<?> c = object.getClass();
            for (Method m : c.getDeclaredMethods()) {
                delegateByMethods.put(m.getName(),object);
            }
            Class<?>[] interfaces = c.getInterfaces();
            set.addAll(Arrays.asList(c.getInterfaces()));
        }
        interfaces = set.toArray(new Class[0]);
    }

    public static Object getNewInstance(Object... objects){
        MyInvocationHandler handler =
                new MyInvocationHandler(objects);
        ClassLoader classLoader = handler.getClass().getClassLoader();
        Class<?>[] classes = handler.interfaces;
        Object object = Proxy.newProxyInstance(classLoader, classes, handler);
        return object;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 根据传入的方法获取被代理的真实对象
        Object obj = delegateByMethods.get(method.getName());
        System.out.println("代理执行" + method.getName() + "方法"+obj==proxy);
        // 被代理的真正对象使用传入的参数调用传入的方法
        return method.invoke(proxy, args);
    }

    public Class<?>[] getInterfaces() {
        return interfaces;
    }
}
