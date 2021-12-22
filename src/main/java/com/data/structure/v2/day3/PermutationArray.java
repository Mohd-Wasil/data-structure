package com.data.structure.v2.day3;

import java.util.Arrays;

public class PermutationArray {

    public static void main(String[] args) {
        int[] intArray1 = {1, 2, 3, 4, 5};
        int[] intArray2 = {2, 3, 5, 1, 4}; // {2,3,1,5,4};

        System.out.println("array 1: " + Arrays.toString(intArray1));
        System.out.println("array 2 :" + Arrays.toString(intArray2));
        boolean isPerm = false;
        if (intArray1.length != intArray2.length) {
            isPerm = false;
        }
        int sum1 = 0, sum2 = 0;
        int p1 = 1, p2 = 1;

        for (int i = 0; i < intArray1.length; i++) {
            sum1 += intArray1[i];
            sum2 += intArray2[i];

            p1 *= intArray1[i];
            p2 *= intArray2[i];
        }
        System.out.println("sum : " + sum1 + " ," + sum2);
        System.out.println("product : " + p1 + " ," + p2);
        if (sum1 == sum2 && p1 == p2) {
            isPerm = true;
            System.out.println("Array is permutation of each other " + isPerm);
        } else {
            System.out.println("array is not permutation of each other");
        }

    }
}
