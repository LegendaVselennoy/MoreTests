package ch2;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import test.ch2.Customer;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("individual")
public class CustomerTest {

    private String CUSTOMER_NAME = "John Smith";

    @Test
    void testCustomer() {
        Customer customer = new Customer(CUSTOMER_NAME);
        assertEquals("John Smith", customer.getName());
    }

}
