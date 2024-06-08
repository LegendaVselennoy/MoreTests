package ch2;

import org.junit.jupiter.api.*;
import test.ch2.PositiveNumberPredicate;

import java.util.Arrays;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class DynamicTestsTest {

    private PositiveNumberPredicate predicate = new PositiveNumberPredicate();


    @BeforeAll
    static void setUpClass() {
        System.out.println("@BeforeAll method");
    }

    @AfterAll
    static void tearDownClass() {
        System.out.println("@AfterAll method");
    }

    @BeforeEach
    void setUp() {
        System.out.println("@BeforeEach method");
    }

    @AfterEach
    void tearDown() {
        System.out.println("@AfterEach method");
    }

    /**
     * Эффективное поведение каждого теста задается исполняемым объектом,
     * предоставляемым в качестве второго параметра метода dynamicTest
     */
    @TestFactory
    Iterator<DynamicTest> positiveNumberPredicateTestCases() {
        return Arrays.asList(
                dynamicTest("отрицательное число",
                        () -> assertFalse(predicate.check(-1))),
                dynamicTest("ноль",
                        () -> assertFalse(predicate.check(0))),
                dynamicTest("положительное число",
                        () -> assertTrue(predicate.check(1)))
        ).iterator();
    }

}
