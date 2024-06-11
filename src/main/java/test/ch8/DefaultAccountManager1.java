package test.ch8;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class DefaultAccountManager1 implements AccountManager{

    private static final Log logger = LogFactory.getLog(DefaultAccountManager1.class);

    /**
     * Находит учетную запись для пользователя с заданным userID.
     */
    public Account findAccountForUser(String userId) {
        logger.debug("Получение учетной записи для пользователя [" + userId + "]");
        ResourceBundle bundle = PropertyResourceBundle.getBundle("технический");
        String sql = bundle.getString("FIND_ACCOUNT_FOR_USER");

        // Некоторая логика кода для загрузки учетной записи пользователя с помощью JDBC
        return null;
    }

    /**
     * Обновляет данную учетную запись.
     */
    public void updateAccount(Account account) {
        // Выполните доступ к базе данных здесь
    }
}
