package com.data.structure.sort;

public class ShellSort {

    private static final int INCREMENT_VALUE = 2;

    public static void main(String[] args) {
        int arr[] = {10, 2, 4, 6, 3, 684, 1, 23, 32, 0, -1};
        System.out.println("before sorting : ");

        printElements(arr);
        //time complexity of shell sort is better than insertion sort
        //between O(N) and O(N2), depends on INCREMENT_ALUE, 2^K complexity - O(N)

        //adaptive..
        shellSort(arr);
        System.out.println("after sorting : ");
        printElements(arr);
    }

    private static void shellSort(int[] arr) {
        int increment = arr.length / INCREMENT_VALUE; //can be any thing 2/3/4
        while (increment >= 1) {
            for (int startIndex = 0; startIndex < increment; startIndex++) {
                insertionSort(arr, startIndex, increment);
            }
            increment = increment / INCREMENT_VALUE;
        }
    }

    private static void printElements(int[] arr) {
        for (int element : arr) {
            System.out.print(element + ",");
        }
        System.out.println();
    }


    private static void insertionSort(int[] arr, int startIndex, int increment) {
        for (int i = startIndex; i < arr.length; i = i + increment) {
            for (int j = Math.min(i + increment, arr.length - 1); j - increment >= 0; j = j - increment) {
                if (arr[j] < arr[j - increment]) {
                    swap(arr, j, j - increment);
                } else {
                    break;
                }
            }
        }
    }

    private static void swap(int[] arr, int j, int i) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
