package designpattern.dynamicproxy;

/**
 * @author HKLLY
 * @date 2019-07-08
 */
public class Interface1Impl implements Interface1 {

    String name;
    @Override
    public void do1(String thing) {
        System.out.println("do1 " + thing);
    }
}
