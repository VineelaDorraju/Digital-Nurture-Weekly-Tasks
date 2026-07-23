package com.tdd.refactor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorRefactorTest {

    @Test
    void testMultiply() {
        CalculatorRefactor calculator = new CalculatorRefactor();
        assertEquals(20, calculator.multiply(4,5));

    }

}