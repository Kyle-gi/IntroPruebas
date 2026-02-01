package service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.sergiolozanoprofe.model.OperationType;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    private org.sergiolozanoprofe.service.CalculatorService calculator;

    @BeforeEach
    void setUp() {
        calculator = new org.sergiolozanoprofe.service.CalculatorService();
    }

    @Test
    void testAdd() {
        assertEquals(5.0, calculator.add(2, 3));
        assertEquals(-1.0, calculator.add(2, -3));
        assertEquals(0.0, calculator.add(0, 0));
    }

    @Test
    void testSubtract() {
        assertEquals(1.0, calculator.subtract(3, 2));
        assertEquals(5.0, calculator.subtract(2, -3));
        assertEquals(0.0, calculator.subtract(5, 5));
    }

    @Test
    void testMultiply() {
        assertEquals(6.0, calculator.multiply(2, 3));
        assertEquals(-6.0, calculator.multiply(2, -3));
        assertEquals(0.0, calculator.multiply(0, 5));
    }

    @Test
    void testDivide() {
        assertEquals(2.0, calculator.divide(6, 3));
        assertEquals(-2.0, calculator.divide(6, -3));
        assertEquals(2.5, calculator.divide(5, 2));
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(5, 0);
        });
    }

    @Test
    void testComputeAdd() {
        double result = calculator.compute(5, OperationType.ADD, 3);
        assertEquals(8.0, result);
    }

    @Test
    void testComputeSubtract() {
        double result = calculator.compute(5, OperationType.SUBTRACT, 3);
        assertEquals(2.0, result);
    }

    @Test
    void testComputeMultiply() {
        double result = calculator.compute(5, OperationType.MULTIPLY, 3);
        assertEquals(15.0, result);
    }

    @Test
    void testComputeDivide() {
        double result = calculator.compute(6, OperationType.DIVIDE, 3);
        assertEquals(2.0, result);
    }

    @Test
    void testComputeDivideByZero() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.compute(5, OperationType.DIVIDE, 0);
        });
    }
}