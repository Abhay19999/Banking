import entity.BankAccount;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userId;
    private String name;
    private List<BankAccount> accounts;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.accounts = new ArrayList<>();
    }
    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }
}
