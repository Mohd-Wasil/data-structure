package com.data.structure.sort;

public class QuickSort {

    public static void main(String[] args) {
        //divide and conqure problem..
        //partition is based on pivot..
        /*all elements smaller than pivots are on left side
                greator than on right side of PIVOT*/

        int arr[] = {10, 2, 4, 6, 3, 684, 1, 23, 32, 0, -1};
        System.out.println("before sorting : ");
        printElements(arr);
        //O(NLog(N))

        //uses divide and conquer, recursion
        //divide till the problem is so small as to be trivial
        //solve the trivial and then build up the complete solution as recursion windows
        quickSort(arr, 0, arr.length);
        System.out.println("after sorting : ");
        printElements(arr);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if(low>=high) {
            return;
        }
        int pivotIndex = partition(arr, low, high);
        quickSort(arr, low, pivotIndex-1);
        quickSort(arr, pivotIndex+1, high);
    }

    public static int partition(int[] listToSort, int low, int high) {
        int pivot = listToSort[low];
        int l = low;
        int h = high;
        while (l < h) {
            while (listToSort[l] <= pivot && l < h) {
                l++;
            }
            while (listToSort[h] > pivot) {
                h--;
            }
            if (l < h) {
                swap(listToSort, l, h);
            }
        }
        swap(listToSort, low, high);
        return h;
    }

    private static void swap(int[] listToSort, int l, int h) {
        int temp = listToSort[l];
        listToSort[l] = listToSort[h];
        listToSort[h] = temp;
    }

    private static void printElements(int[] arr) {
        for (int element : arr) {
            System.out.print(element + ",");
        }
        System.out.println();
    }
}
