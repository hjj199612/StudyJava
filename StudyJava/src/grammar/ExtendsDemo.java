package grammar;

class Grandpa {
    static {
        System.out.println("爷爷在静态代码块");
    }
}

class Father extends Grandpa {
    static {
        System.out.println("爸爸在静态代码块");
    }

    public static int factor = 25;//父子共有的

    public Father() {
        System.out.println("我是爸爸~");
    }
}

class Son extends Father {
    static {
        System.out.println("儿子在静态代码块");
    }
    public static int factor = 25;//子类独有的

    public Son() {
        System.out.println("我是儿子~");
    }
}

public class ExtendsDemo {
    public static void main(String[] args) {
        Son.factor++;
        System.out.println("爸爸的岁数:" + Father.factor); //入口
        System.out.println("爸爸的岁数:" + Son.factor); //入口
        Father.factor++;
        System.out.println("爸爸的岁数:" + Father.factor); //入口
        System.out.println("爸爸的岁数:" + Son.factor); //入口
        Son son = new Son();
        son.factor++;
        System.out.println("爸爸的岁数:" + Father.factor); //入口
        System.out.println("爸爸的岁数:" + Son.factor); //入口
    }
}