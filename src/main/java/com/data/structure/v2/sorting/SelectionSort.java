package com.data.structure.v2.sorting;

public class SelectionSort {

    public void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = findMinIndex(array, i);
            if (minIndex != i) {
                swap(array, minIndex, i);
            }
        }
    }

    private void swap(int[] array, int j, int i) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    private int findMinIndex(int[] array, int index) {
        int minIndex = index;
        for (int i = index + 1; i < array.length; i++) {
            if (array[i] < array[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public void printArray(int[] array) {
        for (int n : array) {
            System.out.print(n + " , ");
        }
        System.out.println("\n");
    }


    public static void main(String[] args) {
        SelectionSort sort = new SelectionSort();
        int[] array = {5, 7, 4, 3, 8, 6, 1, 9, 2};
        sort.printArray(array);
        sort.selectionSort(array);
        sort.printArray(array);
    }
}
