package com.data.structure.v2.sorting;

import java.util.Arrays;

public class BubbleSort {

    int[] array;
    int usedCells = 0;

    public BubbleSort(int size) {
        array = new int[size];
    }

    public void insertElement(int value) {
        if (usedCells == array.length) {
            System.out.println("array s full");
        }
        array[usedCells] = value;
        usedCells++;
    }

    public void printArray() {
        for (int n : array) {
            System.out.print(n + " , ");
        }
        System.out.println("\n");
    }

    public void sort() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i -1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
