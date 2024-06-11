package ch8.web;

import test.ch8.web.ConnectionFactory;

import java.io.InputStream;

public class MockConnectionFactory implements ConnectionFactory {

    /**
     * The input stream for the connection.
     */
    private InputStream inputStream;

    /**
     * Set the input stream.
     */
    public void setData(InputStream stream) {
        this.inputStream = stream;
    }

    /**
     * Get the input stream.
     */
    public InputStream getData() //throws Exception
    {
        return inputStream;
    }
}
