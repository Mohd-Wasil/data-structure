package com.data.structure.v2.day3;

import java.util.Arrays;

public class SumOfPairs {

    public static void main(String[] args) {
        int[] arr = {2, 11, 7,15, 6, 3};
        Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
        int pair = 9;
        findSumOfPairs(arr, pair);
        System.out.println("pairs via v2 :" + Arrays.toString(findSumOfPairsV2(arr, pair)));


    }

    private static int[] findSumOfPairsV2(int[] arr, int pair) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == pair) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("pairs not found");
    }

    private static void findSumOfPairs(int[] arr, int pair) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < pair) {
                int no = pair - arr[i];
                for (int j = i; j < arr.length; j++) {
                    if (no == arr[j]) {
                        System.out.println(" \npairs found at location : " + i + "*" + j + " numbers : " + arr[i] + " - " + arr[j]);
                        break;
                    }
                }
            }
        }
    }
}
