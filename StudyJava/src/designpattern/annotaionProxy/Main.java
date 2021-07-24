package designpattern.annotaionProxy;

/**
 * @author hjj199612
 * @date 2021/7/18 3:55 下午
 * @description
 */
public class Main {

    public static void main(String[] args) {
        Bank atm = IOCFactory.getObject("ATM", ATM.class);
        atm.method();
        System.out.println("---------------------");
        Bank employee = IOCFactory.getObject("Employee", ATM.class);
        employee.method();
    }
}
