package src.designpattern;

/**
 * @Description:
 * @Author: huangjj24
 * @CreateDate: 2021-4-22 9:42
 **/
public class Student implements Person{

    private String name;

    private int money = 0;

    public Student(String name, int money) {
        this.name = name;
        this.money = money;
    }

    @Override
    public void giveMoney() {
        if(money>=50){
            money-=50;
            System.out.println("交班费giveMoney,花费50元");
        }else {
            System.out.println("没钱交班费");
        }
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public void getMoney() {
        money+=50;
        System.out.println(name+"找家长要钱getMoney,得到50元");
    }

    @Override
    public void identity() {
        System.out.println("identity：学生");
    }
}
