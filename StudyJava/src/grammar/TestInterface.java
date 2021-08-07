package grammar;

/**
 * @Description:
 * @Author: huangjj24
 * @CreateDate: 2021-4-17 16:31
 **/
public interface TestInterface {
    void method();

    default void defaultMethod() {
        System.out.println("调用接口默认方法");
    }

    //    private void privateMethod();jdk8之后支持接口私有方法
    static void staticMethod() {
        System.out.println("调用接口静态方法");
    }

}
