package current.thread.mkevin.demo0;


import current.thread.mkevin.entity.Account;

public class CreateThreadImplementsRunnable implements Runnable {

    private Account account;

    public CreateThreadImplementsRunnable() {
    }

    public CreateThreadImplementsRunnable(Account account) {
        this.account = account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName()+ " Account's information : " + this.account);
    }

    public static void main(String[] args) {

        Account account = new Account("919191","Kevin",true);
        CreateThreadImplementsRunnable thread1 = new CreateThreadImplementsRunnable();
        thread1.setAccount(account);
        new Thread(thread1).start();

        CreateThreadImplementsRunnable thread2 = new CreateThreadImplementsRunnable(account);
        new Thread(thread2).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(account);
            }
        }).start();
    }
}
