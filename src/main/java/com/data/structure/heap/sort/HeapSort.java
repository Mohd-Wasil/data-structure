package com.data.structure.heap.sort;



public class HeapSort {

    public static void main(String[] args) {
        Integer[] values = {4,32, 7, 14, -34,16, 18, 2, 25, 11, -2};
        System.out.println("arrays before sorting..");
        printVal(values);
        heapSort(values);
        System.out.println(" \n arrays AFTER HEAP sorting..");
        printVal(values);

    }

    private static void heapSort(Integer[] values) {
        MaxHeap maxHeap = new MaxHeap(Integer.class);
        maxHeap.array = values;
        maxHeap.heapify(values.length-1);

        int endIndex = values.length -1;
        while(endIndex>0) {
            maxHeap.swap(0, endIndex);
            endIndex--;
            maxHeap.percolateDown(0, endIndex);
        }

    }

    private static void printVal(Integer[] values) {
        for(int val:values) {
            System.out.print(val + " , ");
        }
    }
}
