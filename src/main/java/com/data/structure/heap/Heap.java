package com.data.structure.heap;

import java.lang.reflect.Array;

public abstract class Heap<T extends Comparable> {

    protected static int MAX_SIZE = 40;
    protected T[] array;
    protected int count = 0;

    public Heap(Class<T> clazz) {
        this(clazz, MAX_SIZE);
    }

    public Heap(Class<T> clazz, int size) {
        array = (T[]) Array.newInstance(clazz, size);
        //instantiate array in java
    }

    public int getLeftChildIndex(int index) {
        int leftChildIndex = 2 * index + 1;
        if (leftChildIndex >= count) {
            return -1;
        }
        return leftChildIndex;
    }

    public int getRightChildIndex(int index) {
        int rightChildIndex = 2 * index + 2;
        if (rightChildIndex >= count) {
            return -1;
        }
        return rightChildIndex;
    }

    public int getParentIndex(int index) {
        if (index < 0 || index > count) {
            return -1;
        }
        return (index - 1) / 2;
    }

    public int getCount() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == array.length;
    }

    public T getElementAtIndex(int index) {
        return array[index];
    }

    protected void swap(int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public  abstract void siftDown(int index);

    public  abstract void siftUp(int index);
}
