package com.data.structure.v2;

public class RecursionExample {

    public static void main(String[] args) {

        System.out.println("power of two: " + powerOfTwo(5));
        System.out.println("factorial : " + factorial(4));
        System.out.println("fibanoicci : " + 5 + "th number ");
        for (int i = 0; i < 10; i++) {
            System.out.print(fibanoicci(i) + " ,");
        }
        System.out.println("\n" + "element :" + fibanoicci(7));
        System.out.println("sum of digit : " + sumofDigits(789));
        System.out.println("power of a number : " + powerOfANumber(3, 6));
        System.out.println("gcd of two numbers : " + gcd(18, 48));
        System.out.println("decimal to binary  : " + decimalToBinary(10));


    }

    private static int decimalToBinary(int n) {

        if (n < 0) { //unconditional case
            return -1;
        }
        if (n / 2 == 0) {
            return n; //stop
        }
        int val = n % 2 + 10 * decimalToBinary(n / 2); //the flow
        return val;

    }

    private static int gcd(int a, int b) {
        if (a < 0 || b < 0) {
            return -1; //unintentional cases
        }
        if (b == 0) {
            return a;//base condition
        }

        return gcd(b, a % b); //the flow
    }

    private static int powerOfANumber(int x, int n) {//x^n, base^exponent
        if (n < 0) return -1; //unintentional case
        if (n == 0) return 1; //eit csae
        return x * powerOfANumber(x, n - 1); //the flow
    }

    private static int sumofDigits(int i) {
       /* if (i < 0) {
            return -1;
        }*/
        if (i == 0 || i < 0) { //base case and unintenaiola case
            return 0;
        }
        return i % 10 + sumofDigits(i / 10); //the flow
    }

    private static int fibanoicci(int n) {
        if (n < 0) {
            return -1;
        }
        if (n == 0 || n == 1) return n;
        //if( pointer ==1) return 1;
        return fibanoicci(n - 1) + fibanoicci(n - 2);

    }

    private static int factorial(int n) {
        if (n < 0) {
            return -1;
        }
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }

    }

    private static int powerOfTwo(int n) {
        if (n == 0) {
            return 1;
        } else {
            int value = 2 * powerOfTwo(n - 1);
            return value;
        }

    }
}
