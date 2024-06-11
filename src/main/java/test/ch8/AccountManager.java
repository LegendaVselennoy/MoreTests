package test.ch8;

public interface AccountManager {

    Account findAccountForUser(String userId);
    void updateAccount(Account account);

}
