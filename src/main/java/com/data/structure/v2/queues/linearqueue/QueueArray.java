package com.data.structure.v2.queues.linearqueue;

public class QueueArray {

    int array[];
    int topOfQueue;
    int beginningOfQueue;

    public QueueArray(int size) {
        array = new int[size];
        topOfQueue = beginningOfQueue = -1;
        System.out.println("queue successfully created : " + size);
    }

    public boolean isFull() {
        return topOfQueue == array.length - 1;
    }

    public boolean isEmpty() {
        return beginningOfQueue == -1 || beginningOfQueue == array.length;
    }

    public void enQueue(int value) {
        if (isFull()) {
            System.out.println("queue is full!!");
            return;
        } else if (isEmpty()) {
            beginningOfQueue = 0;
            topOfQueue =0;
            array[topOfQueue] = value;
            System.out.println("successfully inserted value to queue : " + value);
        } else {
            topOfQueue++;
            array[topOfQueue] = value;
            System.out.println("successfully inserted value to queue : " + value);
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("queue is empty!!");
            return Integer.MIN_VALUE;
        } else {
            int result = array[beginningOfQueue];
            beginningOfQueue = beginningOfQueue + 1;
            if(beginningOfQueue > topOfQueue) { // after dequeue of last element
                beginningOfQueue = -1;
                topOfQueue = -1;
            }
            return result;
        }
    }

    public int peek(){
        if(isEmpty()) {
            System.out.println("Queue is empty!!");
            return Integer.MIN_VALUE;
        } else{
            return array[beginningOfQueue];
        }
    }

    public void delete() {
        array = null;
        System.out.println("queue is successfully deleted..");
    }
}
