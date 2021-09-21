package com.data.structure.sort;

public class InsertionSort {

    public static void main(String[] args) {
        int arr[] = {10, 2, 4, 6, 3, 684, 1, 23, 32, 0, -1};
        System.out.println("before sorting : ");
        printElements(arr);
        insertionSort(arr);

        //adaptive , sort can break early
        //worst case - o(N2)
        //low overhead...less swaps and can leverage caching..
        //good for divide and conquer ..
        System.out.println("after sorting : ");
        printElements(arr);
    }

    private static void insertionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                } else {
                    System.out.println("break");
                    break;
                }
                printElements(array);
            }
        }
    }

    private static void swap(int[] array, int j, int i) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;

    }

    private static void printElements(int[] arr) {
        for (int element : arr) {
            System.out.print(element + ",");
        }
        System.out.println();
    }
}
