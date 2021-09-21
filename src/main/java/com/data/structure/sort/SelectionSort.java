package com.data.structure.sort;

public class SelectionSort {

    public static void main(String[] args) {
        int arr[] = {10, 2, 4, 6, 3, 684,1, 23, 32, 0, -1};
        System.out.println("before sorting : ") ;
        printElements(arr);
        //do selection sort //O(N2)
        //doesnt use extra space but take more time..
        selectionSort(arr);
        System.out.println("after sorting : ");
        printElements(arr);
    }

    private static void printElements(int[] arr) {
        for(int element : arr){
            System.out.print(element + ",");
        }
        System.out.println();
    }
    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    System.out.println("sort 1");
                    swap(arr, i, j);
                }
            }
        }
    }

    private static void swap(int[] arr, int iIndex, int jIndex) {
        int temp = arr[iIndex];
        arr[iIndex] = arr[jIndex];
        arr[jIndex] = temp;
    }


}
