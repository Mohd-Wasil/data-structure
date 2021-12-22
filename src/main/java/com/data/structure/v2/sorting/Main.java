package com.data.structure.v2.sorting;

public class Main {

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort(9);
        bubbleSort.insertElement(5);
        bubbleSort.insertElement(9);
        bubbleSort.insertElement(3);
        bubbleSort.insertElement(1);
        bubbleSort.insertElement(2);
        bubbleSort.insertElement(8);
        bubbleSort.insertElement(4);
        bubbleSort.insertElement(7);
        bubbleSort.insertElement(6);
        bubbleSort.printArray();
        bubbleSort.sort();
        bubbleSort.printArray();

    }
}
