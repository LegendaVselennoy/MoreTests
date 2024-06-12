package ch14;

import org.junit.jupiter.api.Test;
import test.ch9.Passenger;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PassengersTest {

    @Test
    void testPassenger() throws IOException{
        Passenger passenger=new Passenger("123-456-789", "John Smith");
        assertEquals("Пассажир John Smith с идентификатором: 123-456-789",passenger.toString());
    }
}
