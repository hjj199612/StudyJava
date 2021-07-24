package current.thread.mkevin.demo0;

import src.current.thread.mkevin.entity.Account;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CreateThreadImplementsCallable implements Callable<Account> {

    private Account account;

    public CreateThreadImplementsCallable() {
    }

    public CreateThreadImplementsCallable(Account account) {
        this.account = account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public Account call() throws Exception {
        System.out.println(Thread.currentThread().getName()+ " Account's information : " + this.account);
        this.account.setValid(false);
        Thread.sleep(3000);
        return this.account;
    }

    public static void main(String[] args) {

        Account account = new Account("929292","Kevin",true);
        CreateThreadImplementsCallable call = new CreateThreadImplementsCallable();
        call.setAccount(account);
        FutureTask<Account> ft = new FutureTask<Account>(call);
        new Thread(ft).start();

        try {
            Account result  = ft.get();
            System.out.println("result : " + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
