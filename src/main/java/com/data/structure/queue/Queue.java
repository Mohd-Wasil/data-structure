package com.data.structure.queue;

import com.data.structure.queue.exception.QueueOverFlowException;
import com.data.structure.queue.exception.QueueUnderFlowException;

import java.lang.reflect.Array;

public class Queue<T> {

    private static final int SPECIAL_EMPTY_VALUE = -1;
    private static int MAX_SIZE = 30;
    private T[] elements;

    private int headIndex = SPECIAL_EMPTY_VALUE;
    private int tailIndex = SPECIAL_EMPTY_VALUE;

    public Queue(Class<T> clazz) {
        elements = (T[]) Array.newInstance(clazz, MAX_SIZE);
    }
    //all operations are time complexity O(1)
    public boolean isEmpty() {
        return headIndex == SPECIAL_EMPTY_VALUE;
    }
    //all operations are time complexity are O(1)
    public boolean isFull() {
        int nextIndex = (tailIndex + 1) % elements.length;
        return nextIndex == headIndex;
    }
    //all operations are time complexity are O(1)
    public void enqueue(T data) throws QueueOverFlowException {
        if (isFull()) {
            throw new QueueOverFlowException();
        }
        tailIndex = (tailIndex + 1) % elements.length;//wrap around circular array
        if (isEmpty()) {
            headIndex = tailIndex;
        }
        elements[tailIndex] = data;
    }
    //all operations are time complexity are O(1)
    public T dequeue() throws QueueUnderFlowException {
        if (isEmpty()) {
            throw new QueueUnderFlowException();
        }

        T data = elements[headIndex];
        if (headIndex == tailIndex) {
            //this was the last eleemnt in the queue
            headIndex = SPECIAL_EMPTY_VALUE;
        } else {
            headIndex = (headIndex + 1) % elements.length;
        }
        return data;
    }

    //all operations are time complexity are O(1)
    public T peek() throws QueueUnderFlowException {
        if(isEmpty()){
            throw new QueueUnderFlowException();
        }
        return elements[headIndex];
    }
}
