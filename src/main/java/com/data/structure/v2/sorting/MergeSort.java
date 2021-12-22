package com.data.structure.v2.sorting;

public class MergeSort {
    int[] array;

    public MergeSort(int[] arr) {
        array = arr;
    }

    private void merge(int[] A, int start, int mid, int end) {
        int[] tempArray = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            if (A[i] <= A[j]) {
                tempArray[k] = A[i];
                i = i + 1;
            } else {
                tempArray[k] = A[j];
                j = j + 1;
            }
            k = k + 1;
        }
        while (j <= end) {
            tempArray[k] = A[j];
            j++;
            k++;
        }
        while (i <= mid) {
            tempArray[k] = A[i];
            i++;
            k++;
        }


        for (i = start; i <= end; i++) {
            A[i] = tempArray[i - start];
        }
    }

    public void printArray() {
        for (int n : array) {
            System.out.print(n + " , ");
        }
        System.out.println("\n");
    }

    public void mergeSort(int[] A, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(A, start, mid);
            mergeSort(A, mid + 1, end);
            merge(A, start, mid, end);
        }

    }

    public static void main(String[] args) {
        //int[] array = {5, 3, 4, 7, 2, 8, 6, 9, 1};
        int []array ={6,4,3,7,5,1,2};

        MergeSort mergeSort = new MergeSort(array);
        mergeSort.printArray();
        mergeSort.mergeSort(array, 0, array.length -1);
        mergeSort.printArray();

    }
}
