package src.designpattern.annotaionProxy;

/**
 * @Description:
 * @Author: huangjj24
 * @CreateDate: 2021-4-17 16:31
 **/
@Transaction
public interface Bank {
    void method();

    default void defaultMethod() {
        System.out.println("默认银行来算账！");
    }

    //    private void privateMethod();jdk8之后支持接口私有方法
    static void staticMethod() {
        System.out.println("静态银行来算账！");
    }

}
