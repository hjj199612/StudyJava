package src.designpattern;


/**
 * @Description:
 * @Author: huangjj24
 * @CreateDate: 2021-4-22 14:00
 **/
public class StaticProxy {
    public static void main(String[] args) {
        //班长代理学生交班费  静态代理
        Student[] students = new Student[6];
        Monitor monitor = new Monitor("班长",20);
        for (int i = 0; i < 5; i++) {
            Student student = new Student("学生"+i,0);
            if (i == 3) {
                student.setName("张三");
                student.getMoney();
            }
            students[i]=student;
        }
        monitor.students=students;
        students[5]=monitor;
        monitor.giveMoneyPxy();
    }
}
