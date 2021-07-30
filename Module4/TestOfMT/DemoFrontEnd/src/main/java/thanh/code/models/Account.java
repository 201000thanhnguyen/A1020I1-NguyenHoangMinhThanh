package thanh.code.models;

public class Account {
    private String accountName;
    private String accountPassword;
    private String accountPermission;

    public String getAccountPermission() {
        return accountPermission;
    }

    public void setAccountPermission(String accountPermission) {
        this.accountPermission = accountPermission;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public Account() {
    }

    public Account(String accountName, String accountPassword, String accountPermission) {
        this.accountName = accountName;
        this.accountPassword = accountPassword;
        this.accountPermission = accountPermission;
    }

    public Account(String accountName, String accountPassword) {
        this.accountName = accountName;
        this.accountPassword = accountPassword;
    }
}
