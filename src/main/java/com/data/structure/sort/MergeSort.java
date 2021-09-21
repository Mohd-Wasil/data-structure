package com.data.structure.sort;

public class MergeSort {

    public static void main(String[] args) {
        int arr[] = {10, 2, 4, 6, 3, 684, 1, 23, 32, 0, -1};
        System.out.println("before sorting : ");
        printElements(arr);
        //uses divide and conquer, recursion
        //divide till the problem is so small as to be trivial
        //solve the trivial and then build up the complete solution as recursion windows
        mergeSort(arr);
        System.out.println("after sorting : ");
        printElements(arr);
    }

    private static void mergeSort(int[] listToSort) {
        //..base case so that mergeSOrt terminates
        if (listToSort.length == 1) {
            return;
        }
        //finding mid point..
        int midIndex = listToSort.length / 2 + listToSort.length % 2;
        int []listFirstHalf = new int[midIndex];
        int []listSecondHalf = new int [listToSort.length-midIndex];
        split(listToSort, listFirstHalf,listSecondHalf);

        mergeSort(listFirstHalf);
        mergeSort(listSecondHalf);
        merge(listToSort, listFirstHalf, listSecondHalf);

    }

    public static void merge(int[] listToSort, int[] listFirstHalf, int[] listSecondHalf) {
        int mergeIndex = 0;
        int firstHalfIndex = 0;
        int secondHalfIndex = 0;
        while (firstHalfIndex < listFirstHalf.length && secondHalfIndex < listSecondHalf.length) {
            if (listFirstHalf[firstHalfIndex] < listSecondHalf[secondHalfIndex]) {
                listToSort[mergeIndex] = listFirstHalf[firstHalfIndex];
                firstHalfIndex++;
            } else if (secondHalfIndex < listSecondHalf.length) {
                listToSort[mergeIndex] = listSecondHalf[secondHalfIndex];
                secondHalfIndex++;
            }
            mergeIndex++;
        }
        if (firstHalfIndex < listFirstHalf.length) {
            while (mergeIndex < listToSort.length) {
                listToSort[mergeIndex++] = listFirstHalf[firstHalfIndex++];
            }
        }
        if (secondHalfIndex < listSecondHalf.length) {
            while (mergeIndex < listToSort.length) {
                listToSort[mergeIndex++] = listSecondHalf[secondHalfIndex++];
            }
        }

    }

    public static void split(int[] listToSort, int[] listFirstHalf, int[] listSecondHalf) {
        int index = 0;
        int secondHalfIndex = listFirstHalf.length;
        for (int element : listToSort) {
            if (index < secondHalfIndex) {
                listFirstHalf[index] = listToSort[index];
            } else {
                listSecondHalf[index - secondHalfIndex] = listToSort[index];
            }
            index++;
        }
    }

    private static void printElements(int[] arr) {
        for (int element : arr) {
            System.out.print(element + ",");
        }
        System.out.println();
    }

}
