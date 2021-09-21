package com.data.structure.linkedlist;

public class CustomLinkedList<T extends Comparable<T>> implements Cloneable {

    private Node<T> head;
    private int counter;

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public CustomLinkedList() {
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }
}
