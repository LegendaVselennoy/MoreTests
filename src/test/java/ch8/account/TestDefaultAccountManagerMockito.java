package ch8.account;

import org.apache.commons.logging.Log;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import test.ch8.Account;
import test.ch8.DefaultAccountManager2;
import test.ch8.configurations.Configuration;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestDefaultAccountManagerMockito {

    @Mock
    private Configuration configuration;

    @Mock
    private Log logger;


    @Test
    public void testFindAccountByUser() {
        when(configuration.getSQL("FIND_ACCOUNT_FOR_USER")).thenReturn("Getting account for user [1234]");

//        context.checking( new Expectations()
//        {
//            {
//                oneOf (logger).debug("Getting account for user [1234]");
//
//                oneOf (configuration).getSQL( "FIND_ACCOUNT_FOR_USER" );
//                will( returnValue( "SELECT ..." ) );
//            }
//        } );

        DefaultAccountManager2 am = new DefaultAccountManager2(logger, configuration);
        @SuppressWarnings("unused")
        Account account = am.findAccountForUser("1234");

        // Perform asserts here
    }
}
