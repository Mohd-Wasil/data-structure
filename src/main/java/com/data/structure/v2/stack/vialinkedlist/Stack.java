package com.data.structure.v2.stack.vialinkedlist;

public class Stack {
    LinkedList linkedList;

    public Stack() {
        //created stack
        linkedList = new LinkedList();
    }

    public void push(int value) {
        linkedList.insertAtBeginning(value);
        System.out.println("inserted successfully : " + value);
    }

    public boolean isEmpty() {
        return linkedList.head == null;
    }

    public int pop() {
        if(isEmpty()) {
            System.out.println("stack is empty !!!");
            return -1;
        }
        return linkedList.deleteFromBeginning();
    }

    public int peek() {
        if(isEmpty()) {
            System.out.println("stack is empty!!");
            return -1;
        } else {
            return linkedList.head.value;
        }
    }
    public void deleteStack() {
        linkedList.head = null;
        linkedList = null;
        System.out.println("stack is deleted!!");
    }
}
