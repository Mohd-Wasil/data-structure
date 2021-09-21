package com.data.structure.sort;

public class BubbleSort {

    public static void main(String[] args) {
        int arr[] = {10, 2, 0, 4, 6, 3, -1, 684, 1, 23, 32};
        System.out.println("before sorting : ");
        //worst case time complexity  - O(N2)

        printElements(arr);
        bubbleSort(arr);
    }

    private static void bubbleSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapped = true;
                    swap(arr, j, j + 1);
                }
            }
            //can break out early, sorting is adaptive...
            //take no extra space, in place sorting technique..
            if (!swapped) //no swap for a given iteration then list is sorted
                break;
            System.out.println("printing... " + i + "th iteration..");
            printElements(arr);
        }
    }

    private static void swap(int[] arr, int iIndex, int jIndex) {
        int temp = arr[iIndex];
        arr[iIndex] = arr[jIndex];
        arr[jIndex] = temp;
    }

    private static void printElements(int[] arr) {
        for (int element : arr) {
            System.out.print(element + ",");
        }
        System.out.println();
    }
}
