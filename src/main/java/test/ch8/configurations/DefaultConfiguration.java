package test.ch8.configurations;

public class DefaultConfiguration implements Configuration{

    public DefaultConfiguration(String configurationName) {
    }

    /**
     * Метод Getter для получения SQL-запроса, который хотим выполнить
     */
    public String getSQL(String sqlString) {
        return null;
    }

}
