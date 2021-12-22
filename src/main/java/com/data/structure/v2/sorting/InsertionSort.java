package com.data.structure.v2.sorting;

public class InsertionSort {

    public void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i - 1; j >= 0; j--) { //sorted array -> array [i-1]
                if(array[j+1] < array[j]){
                    swap(array, j+1, j);
                }
            }
        }
    }

    private void swap(int[] array, int j, int i) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    public void printArray(int []array ) {
        for (int n : array) {
            System.out.print(n + " , ");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        InsertionSort sort = new InsertionSort();
        int[] array = {5, 3, 4, 7, 2, 8, 6, 9, 1};
        sort.printArray(array);
        sort.insertionSort(array);
        sort.printArray(array);
    }

}
