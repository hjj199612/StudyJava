package current.thread.mkevin.entity;

/**
 * 账户
 */
public class Account {

    private String accountNo;
    private String accountName;
    private boolean valid;

    public Account() {
    }

    public Account(String accountNo, String accountName, boolean valid) {
        this.accountNo = accountNo;
        this.accountName = accountName;
        this.valid = valid;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNo='" + accountNo + '\'' +
                ", accountName='" + accountName + '\'' +
                ", valid=" + valid +
                '}';
    }
}
