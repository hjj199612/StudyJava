package src.designpattern;

/**
 * @Description:
 * @Author: huangjj24
 * @CreateDate: 2021-4-19 9:54
 **/
public interface Person {

    default void sleep(){
        System.out.println("睡觉");
    }
    void giveMoney();
    void getMoney();
    void identity();
    String getName();
    void setName(String name);
}

