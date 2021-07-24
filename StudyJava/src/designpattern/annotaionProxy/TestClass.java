package designpattern.annotaionProxy;

import java.io.FileNotFoundException;
import java.lang.reflect.Proxy;

/**
 * @Description:
 * @Author: huangjj24
 * @CreateDate: 2021-4-17 16:35
 **/
public class TestClass implements TestInterface {

    public static void main(String[] args) throws FileNotFoundException {
        TestClass testClass = new TestClass();
        TestInterface o = (TestInterface) Proxy.newProxyInstance(testClass.getClass().getClassLoader(),
                testClass.getClass().getInterfaces(), new TransactionHandler(testClass));
        o.method();
        System.out.println("------------------");
        o.defaultMethod();
    }

    public void method() {
        System.out.println("调用接口方法");
    }
}
