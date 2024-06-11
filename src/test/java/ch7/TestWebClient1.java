package ch7;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import test.ch7.StubHttpURLConnection;
import test.ch7.WebClient;

import java.io.IOException;
import java.net.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestWebClient1 {

    /**
     * Начнем с вызова setURLStreamHandlerFactory с нашим первым классом-заглушкой, StubStreamHandlerFactory
     */
    @BeforeAll
    public static void setUp(){
        URL.setURLStreamHandlerFactory(new StubStreamHandlerFactory());
    }

    /**
     * Используем несколько (внутренних) классов для использования класса StubHttpURLConnection.
     * StubStreamHandlerFactory мы переопределяем метод createURLStreamHandler,
     * в котором мы возвращаем новый экземпляр нашего второго закрытого класса-заглушки, StubHttpURLStreamHandler.
     */
    private static class StubStreamHandlerFactory implements URLStreamHandlerFactory{

        @Override
        public URLStreamHandler createURLStreamHandler(String protocol) {
            return new StubHttpStreamHandler();
        }
    }

    private static class StubHttpStreamHandler extends URLStreamHandler{

        /**
         * В StubHttpURLStreamHandler мы переопределяем один метод, openConnection,
         * чтобы открыть соединение с заданным URL-адресом
         */
        @Override
        protected URLConnection openConnection(URL url) throws IOException {
            return new StubHttpURLConnection(url);
        }

    }

    @Test
    public void testGetContentOk() throws MalformedURLException{
        WebClient client=new WebClient();

        String workingContent=client.getContent(new URL("http://localhost"));
        assertEquals("It works",workingContent);
    }
}
