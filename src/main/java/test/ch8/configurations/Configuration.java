package test.ch8.configurations;

public interface Configuration {

    /**
     * Метод Getter для выполнения SQL-запроса.
     */
    String getSQL(String sqlString);

}
