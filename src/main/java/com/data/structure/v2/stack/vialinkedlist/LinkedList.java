package com.data.structure.v2.stack.vialinkedlist;

public class LinkedList {

    Node head;
    Node tail;
    int size;

    public Node createSinglyLinkedList(int nodeValue) {
        Node newNode = new Node();
        newNode.value = nodeValue;
        newNode.next = null;
        head = newNode;
        tail = newNode;
        size = 1;
        return head;
    }

    public void insertAtBeginning(int nodeValue) {
        Node newNode = new Node();
        newNode.value = nodeValue;
        newNode.next = head;
        head = newNode;
        size++;
    }

    public int deleteFromBeginning() {
        int value = head.value;
        System.out.println("value deleted on top of stack : "+ value);
        head = head.next;
        size--;
        return value;
    }
}
