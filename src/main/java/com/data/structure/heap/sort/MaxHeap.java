package com.data.structure.heap.sort;


import java.lang.reflect.Array;

public class MaxHeap<T extends Comparable> extends MyHeap {

    public MaxHeap(Class<T> clazz) {
        super(clazz);
    }


    //for max heap//siftDown..
    @Override
    public void percolateDown(int index, int endIndex) {
        int leftChildIndex = getLeftChildIndex(index, endIndex);
        int rightChildIndex = getRightChildIndex(index, endIndex);

        //for max heap,
        // L/R child nodes should be lesser than the Node's value
        if (leftChildIndex != -1
                && array[leftChildIndex].compareTo(array[index]) > 0) {
            swap(leftChildIndex, index);
            percolateDown(leftChildIndex, endIndex);
        }

        if (rightChildIndex != -1 &&
                array[rightChildIndex].compareTo(array[index]) > 0) {
            swap(rightChildIndex, index);
            percolateDown(rightChildIndex, endIndex);
        }
    }

    public void heapify(int endIndex) {
        int parentIndex = getParentIndex(endIndex, endIndex);
        while (parentIndex >= 0) {
            percolateDown(parentIndex, endIndex);
            parentIndex--;
        }
    }
}
