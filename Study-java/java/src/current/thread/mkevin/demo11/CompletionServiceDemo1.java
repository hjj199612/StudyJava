package src.current.thread.mkevin.demo11;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletionServiceDemo1 {
    public static void main(String[] args) {
        try {
            ExecutorService executorService = Executors.newCachedThreadPool();
            CompletionService cs = new ExecutorCompletionService(executorService);
            cs.submit(new SalaryCallable0(100,1000));
            cs.submit(new SalaryCallable1(200,2000));
            //take方法获取并不会跑出异常
            Future f1 = cs.take();
            System.out.println("f1:" + f1);
            Future f2 = cs.take();
            System.out.println("f2:" + f2);
            //get方法会抛出异常
            System.out.println("f1:" + f1.get());
            System.out.println("f2" + f2.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}