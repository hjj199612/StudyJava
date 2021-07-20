package src.current.thread.mkevin.demo12;

import src.current.thread.mkevin.entity.P;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class ForkJoinDemo6 {
    public static void main(String[] args) {
        try {
            List list = new ArrayList();
            list.add(new Callable6("A"));
            list.add(new Callable6("B"));
            list.add(new Callable6("C"));
            list.add(new Callable6("D"));
            list.add(new Callable6("E"));
            ForkJoinPool pool = new ForkJoinPool();
            List<Future<String>> listFuture = pool.invokeAll(list);
            for (int i = 0; i < listFuture.size(); i++) {
                P.l(listFuture.get(i).get());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}