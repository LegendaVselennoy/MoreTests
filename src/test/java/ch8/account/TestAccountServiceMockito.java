package ch8.account;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import test.ch8.Account;
import test.ch8.AccountManager;
import test.ch8.AccountService;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TestAccountServiceMockito {

    /**
     * The mock instance of the AccountManager to use.
     */
    @Mock
    private AccountManager mockAccountManager;

    @Test
    public void testTransferOk() {
        Account senderAccount = new Account("1", 200);
        Account beneficiaryAccount = new Account("2", 100);

        Mockito.lenient().when(mockAccountManager.findAccountForUser("1")).thenReturn(senderAccount);
        Mockito.lenient().when(mockAccountManager.findAccountForUser("2")).thenReturn(beneficiaryAccount);

        AccountService accountService = new AccountService();
        accountService.setAccountManager(mockAccountManager);
        accountService.transfer("1", "2", 50);

        assertEquals(150, senderAccount.getBalance());
        assertEquals(150, beneficiaryAccount.getBalance());
    }

}