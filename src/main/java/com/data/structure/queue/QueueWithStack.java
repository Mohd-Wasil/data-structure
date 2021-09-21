package com.data.structure.queue;

import com.data.structure.queue.exception.QueueOverFlowException;
import com.data.structure.queue.exception.QueueUnderFlowException;
import com.data.structure.stack.Element;
import com.data.structure.stack.Stack;

public class QueueWithStack<T> {

    private Stack<T> forwardStack = new Stack<>();
    private Stack<T> reverseStack = new Stack<>();

    public QueueWithStack() {
    }

    public boolean isEmpty() {
        return forwardStack.isEmpty() && reverseStack.isEmpty();
    }

    public boolean isFull() {
        return forwardStack.isFull() || reverseStack.isFull();
    }
    //operates on forwardStack..
    public void enqueue(T data) throws QueueOverFlowException {
        if (isFull()) {
            throw new QueueOverFlowException();
        }
        try {
            if (forwardStack.isEmpty()) {
                while (!reverseStack.isEmpty()) {
                    forwardStack.push(reverseStack.pop());
                }
            }
            forwardStack.push(data);
        } catch (Exception e) {
            System.err.println("exception " + e.getMessage());
        }
    }
//operates on reverseStack
    public T dequeue() throws QueueUnderFlowException {
        T data = null;
        if (isEmpty()) {
            throw new QueueUnderFlowException();
        }
        try {
            if (reverseStack.isEmpty()) {
                while (!forwardStack.isEmpty()) {
                    reverseStack.push(forwardStack.pop());
                }
                data = reverseStack.pop();
            }
        } catch (Exception e) {
            System.err.println("exception " + e.getMessage());
        }
        return data;
    }

}
