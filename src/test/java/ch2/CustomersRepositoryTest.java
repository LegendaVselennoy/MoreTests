package ch2;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import test.ch2.CustomRepository;
import test.ch2.Customer;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("repository")
public class CustomersRepositoryTest {

    private String CUSTOMER_NAME = "John Smith";
    private CustomRepository repository = new CustomRepository();

    @Test
    void testNonExistence() {
        boolean exists = repository.contains("John Smith");
        assertFalse(exists);
    }

    @Test
    void testCustomerPersistence() {
        repository.persist(new Customer(CUSTOMER_NAME));
        assertTrue(repository.contains("John Smith"));
    }

}
