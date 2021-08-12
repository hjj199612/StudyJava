package current;

/**
 * @author hjj199612
 * @date 2021/8/7 8:18 下午
 * @description
 */
public class ThreadJoinDemo {

    public static void main(String[] args) throws InterruptedException {

//        ReentrantLock lock = new ReentrantLock(true);
        Thread threadSonB = new Thread(() -> {
//            lock.lock();
            System.out.println("子线程B打印B");
//            lock.unlock();
        });

        Thread threadSonC = new Thread(() -> {
//            lock.lock();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程C打印C");
//            lock.unlock();
        });
        threadSonB.start();
        threadSonC.start();
        threadSonB.join();
        threadSonC.join();
//        threadSonB.start();
//        threadSonC.start();
//        Thread.sleep(2000);
//        lock.lock();
        System.out.println("主线程打印A");
//        lock.unlock();
    }

}
