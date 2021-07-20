package src.designpattern;

import java.lang.reflect.Proxy;

/**
 * @Description:
 * @Author: huangjj24
 * @CreateDate: 2021-4-19 9:56
 **/
public class DynamicProxy {

    public static void main(String[] args) {
        Person student1 = new Student("张三", 100);
        Person student2 = new Student("李四", 0);
        Person teacher = new Teacher("老王");

//        MethodsInvocationHandler handler = new MethodsInvocationHandler(student1, student2, teacher);
//
//        Student stuProxy = (Student) Proxy.newProxyInstance(handler.getClass().getClassLoader(),
//                handler.getInterfaces(), handler);
//        stuProxy.giveMoney();

        //创建一个与代理对象相关联的InvocationHandler
        MyInvocationHandler stuHandler = new MyInvocationHandler(student1,student2,teacher);
        //创建一个代理对象stuProxy来代理，代理对象的每个执行方法都会替换执行Invocation中的invoke方法
        Person stuProxy = (Person) Proxy.newProxyInstance(stuHandler.getClass().getClassLoader(),
                stuHandler.getInterfaces(), stuHandler);

        //代理执行上交班费的方法
        stuProxy.giveMoney();
    }

}
