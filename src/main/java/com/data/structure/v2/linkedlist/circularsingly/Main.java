package com.data.structure.v2.linkedlist.circularsingly;

public class Main {

    public static void main(String[] args) {
        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();
        csll.createCircularSinglyLinkedList(132);
        System.out.println("csll head value: "+ csll.head.value);

        csll.insertCSLL(675,0);
        System.out.println("csll head value circular: "+ csll.head.value); //circular
        csll.insertCSLL(34,1);
        csll.insertCSLL(543,54);
        csll.traverseCSLL();
        csll.deleteNodeCSLL(10);
        csll.traverseCSLL();
        csll.deleteEntireCSLL();
        csll.traverseCSLL();
       // System.out.println("infinte circular LL.. traversal...");

        csll.searchNodeCSLL(34);
    }
}
