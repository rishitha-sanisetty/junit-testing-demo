package com.junit.testing.demo.calculator;

public class ArithmeticOperations {

    public int add(int x, int y) {
        return x+y;
    }

    public int subtract(int x, int y) {
        return x-y;
    }

    public int divide(int x, int y) {
        if(y == 0) {
            throw new ArithmeticException();
        }
        return x/y;
    }

    public int squaredNumber(int x) {
        return x*x;
    }

    public int multiply(int x, int y) {
        return x*y;
    }

}
