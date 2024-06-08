package ch7;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.Context;
import test.ch7.WebClient;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestWebClient {

    private WebClient client = new WebClient();

    @BeforeAll
    public static void setUp() throws Exception {
        Server server = new Server(8081);

        Context contentOkContext = new Context(server, "/testGetContentOk");
        contentOkContext.setHandler(new TestGetContentOkHandler());
        server.setStopAtShutdown(true);
        server.start();
    }

    @AfterAll
    public static void tearDown() {
        // Empty
    }

    @Test
    public void testGetContentOk() throws Exception {
        String workingContent = client.getContent(new URL("http://localhost:8081/testGetContentOk"));
        assertEquals("It works", workingContent);
    }

}
