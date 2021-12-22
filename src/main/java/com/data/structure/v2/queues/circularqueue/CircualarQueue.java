package com.data.structure.v2.queues.circularqueue;

public class CircualarQueue {
    int[] array;
    int topOfQueue;
    int beginningOfQueue;
    int size;

    public CircualarQueue(int size) {
        this.array = new int[size];
        topOfQueue = -1;
        beginningOfQueue = -1;
        this.size = size;
        System.out.println("circular queue successfully created with size : " + size);
    }

    public boolean isEmpty() {
        return beginningOfQueue == -1; //or topofqueue ==-1
    }

    public boolean isFull() {
        boolean isFull = false;
        if (beginningOfQueue == 0 & topOfQueue == array.length - 1) {
            isFull = true;
        } else if (topOfQueue + 1 == beginningOfQueue) {
            isFull = true;
        } else {
            isFull = false;
        }
        return isFull;
    }

    public void enQueue(int value) {
        if (isFull()) {
            System.out.println("circular Queue is full!!");
        } else if (isEmpty()) {
            beginningOfQueue = 0;
            topOfQueue = 0;
            array[topOfQueue] = value;
            System.out.println("value : " + value + " successfully inserted");
        } else {
            if (topOfQueue == size - 1) {
                topOfQueue = 0;
            } else {
                topOfQueue++;
            }
            array[topOfQueue] = value;
            System.out.println("value : " + value + " successfully inserted");
        }

    }

    public int deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is EMpty!!");
            return Integer.MIN_VALUE;
        } else {
            int result = array[beginningOfQueue];
            array[beginningOfQueue] = Integer.MIN_VALUE; //random value
            beginningOfQueue++;
            if (beginningOfQueue > size - 1) {
                beginningOfQueue = 0;
            } else if (beginningOfQueue > topOfQueue) {
                beginningOfQueue = -1;
                topOfQueue = -1;
            }
            return result;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("queue is empty..");
            return Integer.MIN_VALUE;
        } else {
            return array[beginningOfQueue];
        }
    }

    public void delete() {
        array = null;
        System.out.println("queue successfully deleted..");
    }

}
