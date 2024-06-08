package test.ch7;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebClient {

    public String getContent(URL url) {
        StringBuffer content = new StringBuffer();
        try {
        // Начнем с открытия HTTP-соединения с помощью класса HttpURLConnection
            HttpURLConnection connection = (HttpURLConnection)
                    url.openConnection();
            connection.setDoInput(true);
        // Читаем содержимое потока до тех пор, пока больше нечего будет читать
            InputStream is = connection.getInputStream();
            byte[] buffer = new byte[2048];
            int count;
            while (-1 != (count = is.read(buffer))) {
                content.append(new String(buffer, 0, count));
            }
        } catch (IOException e) {
        // Если возникает ошибка, мы упаковываем ее в исключение RuntimeException и повторно генерируем
            throw new RuntimeException(e);
        }
        return content.toString();
    }

}
