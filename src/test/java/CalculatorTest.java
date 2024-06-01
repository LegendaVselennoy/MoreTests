import org.junit.jupiter.api.Test;
import test.ch1.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalculatorTest {

    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        double result = calculator.add(10, 50);
        assertEquals(60, result, 0);
    }
}
