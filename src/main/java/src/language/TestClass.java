package src.language;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * @Description:
 * @Author: huangjj24
 * @CreateDate: 2021-4-17 16:35
 **/
public class TestClass implements TestInterface {
    public static void main(String[] args) throws FileNotFoundException {
        TestClass testClass = new TestClass();
        testClass.method();
        testClass.defaultMethod();
        //实现类即子接口不能调用父接口的静态方法
        TestInterface.staticMethod();

        OutputStream out = new FileOutputStream("");
        try(OutputStream out1=out) {//jdk8后可以改写位 try(out)
            out1.write(("可以学习java架构课程").getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void method() {
        System.out.println("调用接口方法");
    }
}
