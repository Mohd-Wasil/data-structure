package com.data.structure.v2.linkedlist.circulardoubly;

public class Main {
    public static void main(String[] args) {
        CircularDoublyLinkedList cdll = new CircularDoublyLinkedList();
        DoublyNode node = cdll.createCDLL(142);
        System.out.println("first element inserted : " + cdll.head.next + " - " + cdll.head.prev + " \nvalue via tail: " + cdll.tail.value);
        cdll.insertNodeCDLL(564, 0);
        cdll.insertNodeCDLL(12,343);
        cdll.insertNodeCDLL(89, 2);
        cdll.insertNodeCDLL(734, 2);
        cdll.traverseCDLL();
        cdll.insertNodeCDLL(391, 4);
        cdll.reverseTraverseCDLL();
        cdll.traverseCDLL();
        cdll.searchNode(734);
        cdll.deleteNodeCDLL(4);
        cdll.traverseCDLL();
        cdll.reverseTraverseCDLL();
        cdll.deleteCDLL();
        cdll.traverseCDLL();

    }
}
