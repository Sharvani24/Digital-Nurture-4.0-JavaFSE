package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathUtilsTest {

    @ParameterizedTest
    @CsvSource({
        "1, 2, 3",
        "2, 3, 5",
        "-1, -1, -2",
        "100, 200, 300"
    })
    public void testAdd(int a, int b, int expected) {
        assertEquals(expected, MathUtils.add(a, b));
    }
}