package current;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

/**
 * @author hjj199612
 * @date 2022/8/30 5:26 ����
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
        // ���и���accountId���Ҷ�Ӧaccount
        List<CompletableFuture<String>> accountFindingFutureList =
                accountIdList.stream().map(accountId -> findAccount(accountId)).collect(Collectors.toList());

        // ʹ��allOf��������ʾ���еĲ�������
        CompletableFuture<Void> allFutures =
                CompletableFuture
                        .allOf(accountFindingFutureList.toArray(new CompletableFuture[accountFindingFutureList.size()]));
        //allFutures.join();


        // ����ķ������԰������ǻ������������Ĵ�����
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

