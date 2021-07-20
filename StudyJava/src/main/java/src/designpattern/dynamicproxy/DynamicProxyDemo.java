package src.designpattern.dynamicproxy;

import java.lang.reflect.Proxy;

/**
 * @author HKLLY
 * @date 2019-07-18
 */
public class DynamicProxyDemo {
    
    public static void main(String[] args) {
        Interface1 interface1 = new Interface1Impl();
        Interface2 interface2 = new Interface2Impl();
        Interface3 interface3 = new Interface3Impl();
        Interface1 interface4 = new Interface1Impl();

        /* 方式一：先获取 InvocationHandler 对象，再获取 proxy 对象*/
        MethodsInvocationHandler handler = new MethodsInvocationHandler
                (interface1, interface2, interface3,interface4);
        Object proxy = Proxy.newProxyInstance(handler.getClass().getClassLoader(),
                handler.getInterfaces(),
                handler);
        ((Interface1) proxy).do1("thing1");
        ((Interface2) proxy).do2("thing2");
        ((Interface3) proxy).do3("thing3");
        ((Interface1) proxy).do1("thing4");
        System.out.println();
        
        /* 方式二：在实现 InvocationHandler 接口的类中定义获取 Proxy 对象的静态方法*/
        proxy = MethodsInvocationHandler.newInstance
                (interface1, interface2, interface3);
        ((Interface1) proxy).do1("thing1");
        ((Interface2) proxy).do2("thing2");
        ((Interface3) proxy).do3("thing3");
    }
}

