package com.junit.testing.demo.calculator;

import java.util.List;

public class CountPrimeNumbers {

    public int countOfPrimeNumbers(List<Integer> list) {

        int counter = 0;

        for(Integer i : list) {
            if(isPrimeNumber(i)) {
                counter++;
            }
        }
        return counter;
    }


    public boolean isPrimeNumber(int inp) {

        boolean isPrime = true;
        int midNumber = Math.abs(inp) / 2;

        for (int idx = 2; idx <= midNumber; idx++) {
            if (inp % idx == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

}
