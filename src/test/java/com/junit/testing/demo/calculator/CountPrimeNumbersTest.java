package com.junit.testing.demo.calculator;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class CountPrimeNumbersTest {

    CountPrimeNumbers countPrimeNumbers = new CountPrimeNumbers();

    @BeforeAll
    static void printStart() {
        System.out.println("Count prime numbers test cases execution ::: Started");
    }

    @AfterAll
    static void printEnd() {
        System.out.println("Count prime numbers test cases execution ::: Ended");
    }

    @Test
    public void testPrimeMethod() {
        boolean res = countPrimeNumbers.isPrimeNumber(5);
        assertTrue(res);
    }

    @Test
    public void testPrimeCount() {
        assertEquals(3, countPrimeNumbers.countOfPrimeNumbers(new ArrayList<>(Arrays.asList(2,3,4,5))));
    }

    @Test
    public void emptyListCheck() {
        assertEquals(0, countPrimeNumbers.countOfPrimeNumbers(new ArrayList<>()));
    }


}