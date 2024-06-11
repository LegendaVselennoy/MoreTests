package ch8.account;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.apache.commons.logging.Log;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.junit5.JUnit5Mockery;
import org.junit.jupiter.api.BeforeEach;
import test.ch8.Account;
import test.ch8.DefaultAccountManager2;
import test.ch8.configurations.Configuration;

public class TestDefaultManagerJMock {

    @RegisterExtension
    Mockery context = new JUnit5Mockery();

    private Configuration configuration;
    private Log logger;

    @BeforeEach
    public void setUp() {
        configuration = context.mock(Configuration.class);
        logger = context.mock(Log.class);
    }

    @Test
    public void testFindAccountByUser() {
        context.checking(new Expectations() {
            {
                oneOf(logger).debug("Getting account for user [1234]");

                oneOf(configuration).getSQL("FIND_ACCOUNT_FOR_USER");
                will(returnValue("SELECT ..."));
            }
        });

        DefaultAccountManager2 am = new DefaultAccountManager2(logger, configuration);
        @SuppressWarnings("unused")
        Account account = am.findAccountForUser("1234");

        // Perform asserts here
    }
}
