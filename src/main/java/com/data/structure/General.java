package com.data.structure;

import java.util.Arrays;

public class General {

    public static void main(String[] args) {
        int[] array = {2, 14, 3, 7, 19, 32, 11};
        String str = "Hampi";
        char[] charArrayInput = str.toCharArray();
        System.out.println("input : " + str);
        printArray1(charArrayInput);
        reverseString(charArrayInput);
        System.out.println("output :" );
        printArray1(charArrayInput);
        calculateSumAndProduct(array);
        printPairs(array);
        System.out.println("array : \n");
        printArray(array);
        reverseArray(array);
        System.out.println("reverse : \n");
        printArray(array);
        allFib(10);
    }

    private static void reverseString(char[] charArrayInput) {
        for (int i = 0; i < charArrayInput.length / 2; i++) {
            char temp = charArrayInput[i];
            charArrayInput[i]= charArrayInput[charArrayInput.length - i -1];
            charArrayInput[charArrayInput.length -i -1] = temp;
        }
    }

    private static void allFib(int n) {
        System.out.println("printing fib for " + n + " terms ... \n");
        for (int i = 0; i < n; i++) {
            System.out.print(fib(i) + " ,");
        }
    }

    private static int fib(int i) {
        if (i <= 0) {
            return 0;
        } else if (i == 1) {
            return 1;
        } else {
            return fib(i - 1) + fib(i - 2);
        }
    }

    private static void printArray1(char[] array) {

        for (char e : array) {
            System.out.print(e + " , ");
        }
    }

    private static void printArray(int[] array) {
        Arrays.stream(array).forEach(e -> System.out.print(e + " , "));
       /* for (int e : array) {
            System.out.print(e + " , ");
        }*/
    }

    private static void reverseArray(int[] array) {

        for (int i = 0; i < array.length / 2; i++) {
            swap(array, i, array.length - i - 1);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void printPairs(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("\n");
            for (int j = 0; j < array.length; j++)
                System.out.print(array[i] + "" + array[j] + ",");
        }
    }

    private static void calculateSumAndProduct(int[] array) {
        int sum = 0;
        int product = 1;
        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
            product = product * array[i];
        }
        System.out.println("sum : " + sum + " , product : " + product);
    }
}
