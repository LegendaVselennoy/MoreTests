package ch8.web;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MockHttpURLConnection extends HttpURLConnection {

    /**
     * Входной поток для соединения.
     */
    private InputStream stream;

    public MockHttpURLConnection() {
        super(null);
    }

    /**
     * Конструктор, который принимает URL-адрес соединения в качестве параметра.
     */
    protected MockHttpURLConnection(URL url) {
        super(url);
    }

    /**
     * Настройте ожидание входного потока.
     */
    public void setExpectedInputStream(InputStream stream) {
        this.stream = stream;
    }

    /**
     * Вернуть входной поток
     */
    public InputStream getInputStream()
            throws IOException {
        return this.stream;
    }

    /**
     * Отключите соединение.
     */
    public void disconnect() {
    }

    /**
     * Подключите соединение.
     */
    public void connect()
            throws IOException {
    }

    /**
     * Используем прокси?
     */
    public boolean usingProxy() {
        return false;
    }
}
