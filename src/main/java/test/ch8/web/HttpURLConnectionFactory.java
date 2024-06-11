package test.ch8.web;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLConnectionFactory implements ConnectionFactory{

    /**
     * URL для подключения.
     */
    private URL url;

    /**
     * Конструктор с URL-адресом в качестве параметра.
     */
    public HttpURLConnectionFactory(URL url) {
        this.url = url;
    }

    /**
     * Чтение данных из входного потока HTTP.
     */
    public InputStream getData()
            throws Exception {
        HttpURLConnection connection = (HttpURLConnection) this.url.openConnection();
        return connection.getInputStream();
    }

}
