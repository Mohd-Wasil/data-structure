package com.data.structure.v2.excercises.dividenconquer;

public class NumberFactor {


    public static void main(String[] args) {

        System.out.println("no of ways.. " + waysTOGetNumber(4));
        System.out.println("no of ways.. " + waysTOGetNumber(5));
        System.out.println("no of ways.. " + waysTOGetNumber(6));
    }

    private static int waysTOGetNumber(int number) {
        //exit criteria 1
        if (number == 0 || number == 1 || number == 2) {
            return 1; //{}, {1}, {1,1}
        }
        //exit criteria 2
        if (number == 3) {
            return 2; //{1 1 1} {3}
        }
        int sum1 = waysTOGetNumber(number - 1);
        int sum2 = waysTOGetNumber(number - 3);
        int sum3 = waysTOGetNumber(number - 4);
        return sum1 + sum2 + sum3;
    }
}
