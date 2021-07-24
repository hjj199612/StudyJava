package current.thread.mkevin.demo0;


import current.thread.mkevin.entity.Account;


public class CreateThreadExtendsThread extends Thread{

    private Account account;

    public CreateThreadExtendsThread() {
    }

    public CreateThreadExtendsThread(Account account) {
        this.account = account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void run(){
        System.out.println(this.getName()+ " Account's information : " + this.account + ","+this.getState());
    }

    public static void main(String[] args) {

        Account account = new Account("909090","Kevin",true);

        CreateThreadExtendsThread thread1 = new CreateThreadExtendsThread();
        thread1.setAccount(account);
        System.out.println(thread1.getState());
        thread1.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(thread1.getState());

        CreateThreadExtendsThread thread2 = new CreateThreadExtendsThread(account);
        thread2.start();
    }
}
