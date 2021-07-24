package designpattern.dynamicproxy;

/**
 * @author HKLLY
 * @date 2019-07-08
 */
public class Interface3Impl implements Interface3 {
    
    @Override
    public void do3(String thing) {
        System.out.println("do3 " + thing);
    }
}
