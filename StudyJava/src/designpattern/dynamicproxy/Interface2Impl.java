package designpattern.dynamicproxy;

/**
 * @author HKLLY
 * @date 2019-07-08
 */
public class Interface2Impl implements Interface2 {
    
    @Override
    public void do2(String thing) {
        System.out.println("do2 " + thing);
    }
}
