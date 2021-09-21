package com.data.structure.heap.sort;

import java.lang.reflect.Array;

public abstract class MyHeap<T extends Comparable> {

    protected T[] array;
    protected int count = 0;
    public static final int MAX_SIZE = 40;

    public MyHeap(Class<T> clazz) {
        this(clazz, MAX_SIZE);
    }

    public MyHeap(Class<T> clazz, int size) {
        array = (T[]) Array.newInstance(clazz, size);
    }

    //for heap sort endIndex needed as heap will shrink.. or grow
    public int getLeftChildIndex(int index, int endIndex) {
        int leftChildIndex = (index * 2) + 1;
        if (leftChildIndex > endIndex) {
            return -1;
        }
        return leftChildIndex;
    }

    //for heap sort endIndex needed as heap will shrink.. or grow
    public int getRightChildIndex(int index, int endIndex) {
        int rightChildIndex = (index * 2) + 2;
        if (rightChildIndex > endIndex) {
            return -1;
        }
        return rightChildIndex;
    }

    public int getParentIndex(int index, int endIndex) {
        if (index < 0 || index > endIndex) {
            return -1;
        }
        return (index - 1) / 2;
    }

    protected void swap(int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public abstract void percolateDown(int index, int endIndex);
}
