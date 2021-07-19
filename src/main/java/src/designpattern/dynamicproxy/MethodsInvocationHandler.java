package src.designpattern.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.*;

/**
 * 根据方法进行动态代理
 *
 * @author HKLLY
 * @date 2019-07-08
 */
public class MethodsInvocationHandler implements InvocationHandler {
    /**
     * 由方法的 name 指向定义该方法的类的对象
     */
    private final Map<String, Object> delegateByMethods;
    
    /**
     * 保存被代理对象实现的接口
     */
    private final Class<?>[] interfaces;
    
    public MethodsInvocationHandler(Object... objects) {
        delegateByMethods = new HashMap<>();
        Set<Class<?>> interfaceSet = new HashSet<>();
        for (Object obj : objects) {
            Class<?> c = obj.getClass();
            for (Method m : c.getDeclaredMethods()) {
                // 只通过非 private 方法代理
                if (m.getModifiers() != Modifier.PRIVATE) {
                    delegateByMethods.put(m.getName(), obj);
                }
            }
            // 获取对象实现的接口
            interfaceSet.addAll(Arrays.asList(c.getInterfaces()));
        }
        // 保存接口
        interfaces = interfaceSet.toArray(new Class[0]);
    }
    
    /**
     * 生成代理对象
     *
     * @param objects 被代理对象
     * @return 代理对象（代理对象关联了被代理对象实现的接口，可以代表任一被代理对象）
     */
    public static Object newInstance(Object... objects) {
        MethodsInvocationHandler handler =
                new MethodsInvocationHandler(objects);
        ClassLoader classLoader = handler.getClass().getClassLoader();
        Class<?>[] interfaces = handler.interfaces;
        //通过 Proxy 的 newProxyInstance() 来创建代理对象
        //第一个参数：用于加载 Proxy 对象的 ClassLoader 对象
        //第二个参数：被代理的真正对象实现的接口
        //第三个参数：关联到 Proxy 的 InvocationHandler 对象
        return Proxy.newProxyInstance(classLoader, interfaces, handler);
    }
    
    /**
     * @param proxy  此 InvocationHandler 关联的代理对象
     * @param method 触发代理调用此方法的真正方法对应的 Method 对象
     * @param args   第二个参数 method 对应的方法的参数
     * @return 被代理的真正对象使用传入的参数调用传入的方法的结果
     * @throws Throwable 异常
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        // 根据传入的方法获取被代理的真实对象
        Object obj = delegateByMethods.get(method.getName());
        // 被代理的真正对象使用传入的参数调用传入的方法
        return method.invoke(obj, args);
    }
    
    /**
     * 获取接口数组
     * @return 接口数组
     */
    public Class<?>[] getInterfaces() {
        return interfaces;
    }
}
