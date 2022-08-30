package current;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

/**
 * @author hjj199612
 * @date 2022/8/30 5:26 下午
 * @description
 */
public class FutureTest {

    public static int i = 0;

    static CompletableFuture<String> findAccount(String accountId) {
        return CompletableFuture.supplyAsync(() -> {
            // mock finding account from database
            try {
                System.out.println(Thread.currentThread().getName() + ":start!");
                Thread.sleep((++i) * 1000);
                System.out.println(Thread.currentThread().getName() + ":end!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "account" + accountId;
        });
    }

    public static void batchProcess(List<String> accountIdList) {
        // 并行根据accountId查找对应account
        List<CompletableFuture<String>> accountFindingFutureList =
                accountIdList.stream().map(accountId -> findAccount(accountId)).collect(Collectors.toList());

        // 使用allOf方法来表示所有的并行任务
        CompletableFuture<Void> allFutures =
                CompletableFuture
                        .allOf(accountFindingFutureList.toArray(new CompletableFuture[accountFindingFutureList.size()]));
        //allFutures.join();


        // 下面的方法可以帮助我们获得所有子任务的处理结果
        CompletableFuture<List<String>> finalResults = allFutures.thenApply(v -> accountFindingFutureList.stream().map(accountFindingFuture -> accountFindingFuture.join())
                .collect(Collectors.toList()));

        try {
            List<String> l = finalResults.get();
            System.out.println(l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<String> l = new ArrayList<String>();
        l.add("11111");
        l.add("22222");
        l.add("33333");
        batchProcess(l);
    }
}

