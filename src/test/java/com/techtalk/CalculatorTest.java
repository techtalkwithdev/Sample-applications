package com.techtalk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private final Calculator calc = new Calculator();

    @Test
    void testAdd() { assertEquals(30, calc.add(10, 20)); }

    @Test
    void testMultiply() { assertEquals(30, calc.multiply(5, 6)); }
}
