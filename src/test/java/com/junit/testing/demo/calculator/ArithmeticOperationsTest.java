package com.junit.testing.demo.calculator;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class ArithmeticOperationsTest {

    private static int counter;
    ArithmeticOperations operations = new ArithmeticOperations();

    @BeforeAll
    static void printStart() {
        System.out.println("Arithmetic operations test cases execution ::: Started");
    }

    @AfterAll
    static void printEnd() {
        System.out.println("Arithmetic operations test cases execution ::: Ended");
    }

    @AfterEach
    public void printCompletion() {
        counter++;
        System.out.printf("Test case execution completed%n", counter);
    }

    @Test
    @DisplayName("Test add method")
    public void testAdd() {
        assertEquals(5, operations.add(2,3));
    }

    /**
     * Execute multiple asserts using assertAll*
     */
    @Test
    public void testSubtract() {

//        assertEquals(1, operations.subtract(4,3));
//        assertEquals(3, operations.subtract(6,3));
        assertAll(
                () -> assertEquals(1, operations.subtract(4,3)),
                () -> assertEquals(3, operations.subtract(6,3))
        );
    }


    /**
     * To test a method that throws an exception, we need to use Executable variable.
     * This is done because when the denominator is zero the execution stops at that point and doesn't go further.
     */
    @Test
    public void testDivideByZero() {

        Executable executable = () -> operations.divide(10,0);
        assertThrows(ArithmeticException.class, executable);
    }

    /** Parameterized Tests
     *
     * */
    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    public void testDivide(int x, int y) {
        assertEquals(x/y, operations.divide(x,y));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 0, -1})
    public void testSquaredNumber(int x) {
        assertEquals(x*x, operations.squaredNumber(x));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2", "5,6", "10,10"})
    public void testMultiply(int x, int y) {
        assertEquals(x*y, operations.multiply(x,y));
    }

}