package com.data.structure.v2.queues.linearqueueLL;


public class LinkedList {

    Node head;
    Node tail;
    int size;

    public Node createLinkedList(int nodeValue) {
        Node newNode = new Node();
        newNode.value = nodeValue;
        newNode.next = null;
        head = tail = newNode;
        size = 1;
        return head;
    }


    public void insertAtEnd(int value) {
        if (head == null) {
            createLinkedList(value);
            return;
        }
        Node newNode = new Node();
        newNode.value = value;
        newNode.next = null;
        tail.next = newNode;
        tail = newNode;
    }

    public int deleteFromBeginning() {
        if(head == null) {
            System.out.println("list is empty!!");
            return Integer.MIN_VALUE;
        }
        int result = head.value;
        head = head.next;
        size--;
        return result;
    }
}
