package com.data.structure.v2.excercises.dividenconquer;

public class FibanoicciSeries {

    public static void main(String[] args) {
        int n = 10;
        for (int i = 1; i <= n; i++) {
            System.out.print(printFibanoicci(i) + " ");
        }
    }

    private static int printFibanoicci(int n) {
        if (n < 1) {
            return -1;// negative use case
        }
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        int value = printFibanoicci(n - 1) + printFibanoicci(n - 2);
        return value;
    }
}
