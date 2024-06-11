package ch8.account;

import test.ch8.Account;
import test.ch8.AccountManager;

import java.util.HashMap;
import java.util.Map;

public class MockAccountManager implements AccountManager {

    /**
     * A Map to hold all the <userId, account> values.
     */
    private Map<String, Account> accounts = new HashMap<>();

    /**
     * A method to add an account to the manager.
     */
    public void addAccount(String userId, Account account) {
        this.accounts.put(userId, account);
    }

    /**
     * A method to find an account for the user with the given ID.
     */
    public Account findAccountForUser(String userId) {
        return this.accounts.get(userId);
    }

    /**
     * A method to update the given account. Notice that we don't need this method and that's why we leave it with a
     * blank implementation.
     */
    public void updateAccount(Account account) {
        // do nothing
    }

}
