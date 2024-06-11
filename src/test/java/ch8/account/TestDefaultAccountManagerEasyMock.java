package ch8.account;

import org.apache.commons.logging.Log;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.ch8.Account;
import test.ch8.DefaultAccountManager2;
import test.ch8.configurations.Configuration;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;

public class TestDefaultAccountManagerEasyMock {

    private Log logger;

    private Configuration configuration;

    @BeforeEach
    public void setUp() {
        logger = createMock("logger", Log.class);
        configuration = createMock("configuration", Configuration.class);
    }

    @Test
    public void testFindAccountByUser() {
        expect(configuration.getSQL("FIND_ACCOUNT_FOR_USER")).andReturn("SELECT ..");
        replay();

        DefaultAccountManager2 am = new DefaultAccountManager2(logger, configuration);

        @SuppressWarnings("unused")
        Account account = am.findAccountForUser("1234");

        // Perform asserts here
    }

}
