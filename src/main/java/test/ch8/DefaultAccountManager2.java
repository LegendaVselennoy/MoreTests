package test.ch8;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import test.ch8.configurations.Configuration;
import test.ch8.configurations.DefaultConfiguration;

public class DefaultAccountManager2 implements AccountManager{

    private Log logger;

    /**
     * Конфигурация для использования.
     */
    private Configuration configuration;

    /**
     * Конструктор без параметров.
     */
    public DefaultAccountManager2() {
        this(LogFactory.getLog(DefaultAccountManager2.class),
                new DefaultConfiguration("технический"));
    }

    /**
     * Конструктор с регистратором и параметрами конфигурации.
     */
    public DefaultAccountManager2(Log logger,
                                  Configuration configuration) {
        this.logger = logger;
        this.configuration = configuration;
    }

    /**
     * Находит учетную запись для пользователя с заданным userID.
     */
    public Account findAccountForUser(String userId) {
        this.logger.debug("Получение учетной записи для пользователя ["
                + userId + "]");
        this.configuration.getSQL("FIND_ACCOUNT_FOR_USER");

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
