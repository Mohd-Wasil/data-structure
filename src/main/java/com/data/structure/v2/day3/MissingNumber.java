package com.data.structure.v2.day3;

import java.util.Arrays;

public class MissingNumber {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 9, 10,11,12,13};
        int size = 13;
        int missingNo = findMissingNumberInArray(arr, size);
        Arrays.stream(arr).forEach(e -> System.out.print(e +" "));
        System.out.println("\n missing no in array : "+  missingNo);
    }

    private static int  findMissingNumberInArray(int[] arr, int size) {
        int sum = (size * (size + 1)) / 2;
        int actualSum =0;
        for (int i : arr) {
            actualSum += i;
        }
        return sum - actualSum;
    }
}
