package designpattern.annotaionProxy;

/**
 * @author hjj199612
 * @date 2021/7/18 4:09 下午
 * @description
 */
public class Employee implements Bank {
    @Override
    public void method() {
        System.out.println("柜员算账算错了！");
        throw new RuntimeException("柜员算账算错了！");
    }
}
