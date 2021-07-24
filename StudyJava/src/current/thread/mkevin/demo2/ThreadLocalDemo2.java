package current.thread.mkevin.demo2;

public class ThreadLocalDemo2 extends Thread{

    //多个线程之间读取副本, 父子线程之间复制传递
    public static InheritableThreadLocal<Integer> tl = new InheritableThreadLocal<>();

    public ThreadLocalDemo2(){
    }

    public void run(){
        System.out.println(Thread.currentThread().getName()+ " get tl is : " + tl.get());
        new ThreadLocalDemo2().start();
    }

    public static void main(String[] args) throws InterruptedException {
        tl.set(1001);
        new ThreadLocalDemo2().start();

        tl.set(2002);
        new ThreadLocalDemo2().start();

    }

}


