package test.ch7;


import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.ResourceHandler;
import org.mortbay.jetty.servlet.Context;

public class Sample {
    public static void main(String[] args) {
        Server server=new Server(8081);

        /**
         * Создаем объект Context, который обрабатывает HTTP-запросы и
         * передает их различным обработчикам. Сопоставляем контекст с уже созданным
         * экземпляром сервера и корневой (/) URL. Метод setResourceBase устанавливает
         * корень документа, из которого будут обслуживаться ресурсы. На следующей строке мы прикрепляем
         * ResourceHandler в корень для обслуживания файлов из файловой системы.
         */
        Context root=new Context(server,"/");
        root.setResourceBase("./pom.xml");
        root.setHandler(new ResourceHandler());

        try {
            server.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
