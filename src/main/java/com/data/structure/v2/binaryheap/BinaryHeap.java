package com.data.structure.v2.binaryheap;

public class BinaryHeap {

    int array[];
    int sizeOfTree;

    public BinaryHeap(int size) {
        array = new int[size + 1];
        sizeOfTree = 0;
        System.out.println("binary heap of array type is created!!");
    }

    public boolean isEmpty() {
        return sizeOfTree == 0;
    }

    public Integer peek() {
        if (isEmpty()) {
            System.out.println("binary heap is empty...");
            return null;
        }
        System.out.println("peek  : " + array[1]);
        return array[1];
    }

    public int sizeOfBinaryHeap() {
        return sizeOfTree;
    }

    public void levelOrder() {
        if (isEmpty()) {
            System.out.println("binary heap is empty..");
        }
        for (int i = 1; i <= sizeOfTree; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("\n");
    }

    public void heapifyBottomToTop(int index, String heapType) {
        int parent = index / 2;
        if (index <= 1) {
            return;
        }
        if (heapType.equalsIgnoreCase("Min")) {
            if (array[index] < array[parent]) {
                //swap
                int temp = array[index];
                array[index] = array[parent];
                array[parent] = temp;
            }
        } else if (heapType.equalsIgnoreCase("Max")) {
            if (array[index] > array[parent]) {
                int temp = array[index];
                array[index] = array[parent];
                array[parent] = temp;
            }
        }
        heapifyBottomToTop(parent, heapType); //o(Log N) - time and space
    }

    public boolean isFull() {
        return sizeOfTree == array.length - 1;
    }

    //o(Log N)
    public void insert(int value, String heapType) {
        if (isFull()) {
            System.out.println("binary heap is full");
            return;
        }
        array[sizeOfTree + 1] = value;
        sizeOfTree++;
        heapifyBottomToTop(sizeOfTree, heapType);
        System.out.println("value : " + value + " is inserted im binary heap");
    }

    public void heapifyTopToBottom(int index, String heapType) {
        int leftChildIndex = 2 * index;
        int rightChildIndex = 2 * index + 1;
        int nextSwapIndex = index;
        if (leftChildIndex > sizeOfTree) {
            return;
        }
        if (heapType.equalsIgnoreCase("Min")) {
            //end condition....
            if (leftChildIndex == sizeOfTree) {
                if (array[index] > array[leftChildIndex]) {
                    swap(array, index, leftChildIndex);
                }
                return;
            }
            if (array[leftChildIndex] < array[rightChildIndex]) {
                nextSwapIndex = leftChildIndex;
            } else {
                nextSwapIndex = rightChildIndex;
            }
            if (array[index] > array[nextSwapIndex]) {
                swap(array, index, nextSwapIndex);
            }

        }

        if (heapType.equalsIgnoreCase("Max")) {
            //end condition
            if (leftChildIndex == sizeOfTree) {
                if (array[index] < array[leftChildIndex]) {
                    swap(array, index, leftChildIndex);
                }
                return;
            }
            if (array[leftChildIndex] > array[rightChildIndex]) {
                nextSwapIndex = leftChildIndex;
            } else {
                nextSwapIndex = rightChildIndex;
            }
            if(array[index] < array[nextSwapIndex]) {
                swap(array, index, nextSwapIndex);
            }

        }
        heapifyTopToBottom(nextSwapIndex, heapType);
    }

    //always top/rrot node
    //o(Log n) time and space
    public Integer extractHeadOfBP(String heapType) {
        if (isEmpty()) {
            System.out.println("binary heap is empty..");
            return null;
        }
        int data = array[1];
        array[1] = array[sizeOfTree];
        sizeOfTree = sizeOfTree - 1;
        System.out.println("data : " + data + " removed from binary heap...");
        heapifyTopToBottom(1, heapType);
        return data;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void deleteBinaryHeap() {
        array = null;
        System.out.println("binary heap is deleted...");
    }
}




