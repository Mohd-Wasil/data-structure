package com.data.structure.v2.linkedlist.excercise.singly;

public class LinkedList {

    public Node head;
    public Node tail;
    public int size;

    public Node createLinkedList(int nodeValue) {
        Node newNode = new Node();
        newNode.value = nodeValue;
        newNode.next = null;
        head = newNode;
        tail = newNode;
        size = 1;
        return newNode;
    }

    public void insertNode(int nodeValue) { //by default at end of node, singlyLinkedList
        if(head == null) {
            createLinkedList(nodeValue);
            return;
        }
        Node newNode = new Node();
        newNode.value = nodeValue;
        newNode.next = null;
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public void traversalLL() {
        Node tempNode = head;
        while(tempNode!=null) {
            System.out.print(tempNode.value + " ");
            tempNode = tempNode.next;
        }
        /*for(int i= 0; i<size; i++) {
            System.out.print(tempNode.value);
            if( i!= size-1){
                System.out.print("->");
            }
            tempNode = tempNode.next;
        }*/
        System.out.println("\n");
    }
}
