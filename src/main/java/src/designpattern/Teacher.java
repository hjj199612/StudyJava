package src.designpattern;

/**
 * @Description:
 * @Author: huangjj24
 * @CreateDate: 2021-4-22 13:47
 **/
public class Teacher implements Person {

    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void giveMoney() {
        System.out.println("老师消费giveMoney");
    }

    @Override
    public void getMoney() {
        System.out.println("老师领工资getMoney");
    }

    @Override
    public void identity() {
        System.out.println("identity：老师");
    }
}
