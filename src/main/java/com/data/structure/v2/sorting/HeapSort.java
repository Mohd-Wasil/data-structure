package com.data.structure.v2.sorting;

import com.data.structure.v2.binaryheap.BinaryHeap;

public class HeapSort {

    int arr[];

    public HeapSort(int []arr) {
        this.arr = arr;
    }

    public void heapSort(){
        BinaryHeap bh = new BinaryHeap(arr.length);
        for(int value : arr) {
            bh.insert(value, "Min");
        }
        bh.levelOrder();
        for(int i =0;i<arr.length;i++) {
            arr[i] =bh.extractHeadOfBP("Min");
        }
    }

    public void printArray() {
        for (int n : arr) {
            System.out.print(n + " , ");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        int [] array = {15, 10, 40, 20, 50, 10, 30, 45, 5};

        HeapSort sort = new HeapSort(array);
        System.out.println("before heap sort..");
        sort.printArray();
        sort.heapSort();
        System.out.println("after heap sort..");
        sort.printArray();
    }
}
