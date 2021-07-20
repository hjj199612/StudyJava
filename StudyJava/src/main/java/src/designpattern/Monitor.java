package src.designpattern;

/**
 * @Description: 班长 代理模式，AOP
 * @Author: huangjj24
 * @CreateDate: 2021-4-22 13:52
 **/
public class Monitor extends Student{

    public Student[] students;

    public Monitor(String name, int money) {
        super(name, money);
    }

    public void giveMoneyPxy() {
        for (int i = 0; i < students.length; i++) {
            System.out.print(students[i].getName());
            students[i].giveMoney();
        }
    }
    @Override
    public void identity() {
        System.out.println("identity：学生班长");
    }
}
