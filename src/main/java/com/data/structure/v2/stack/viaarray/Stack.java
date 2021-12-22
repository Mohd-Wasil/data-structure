package com.data.structure.v2.stack.viaarray;

public class Stack {
    int array[];
    int topOfStack;

    public Stack(int size) {
        this.array = new int[size];
        this.topOfStack = -1;
        System.out.println("stack successfully created with size of : " + size);
    }

    public boolean isEmpty() {
        return topOfStack == -1;
    }

    public boolean isFull() {
        return topOfStack == array.length - 1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("stack is full!!");
        } else {
            array[++topOfStack] = value;
            System.out.println("value : " + value + " is successfully inserted!!");
        }
    }

    public int pop() {
        int topElementOnStack = Integer.MIN_VALUE;
        if (isEmpty()) {
            System.out.println("Stack is empyy!!");
        } else {
             topElementOnStack = array[topOfStack];
            System.out.println("array[topOfStack] :" + array[topOfStack]);
            topOfStack = topOfStack - 1;
        }
        return topElementOnStack;
    }

    public int peek() {
        if(isEmpty()) {
            System.out.println("stack is empty.. doing peek operation");
            return  -1;
        }
        System.out.println("element on top of Stack : "+ array[topOfStack]);
        return array[topOfStack];
    }

    public void delete(){
        if(isEmpty()) {
            System.out.println("stack is empty..");
        }
        array = null;
        //topOfStack = -1;
        System.out.println("stack is deleted ..");
    }
}
