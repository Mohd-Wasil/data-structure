package com.data.structure.v2.linkedlist.singly;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.createSinglyLinkedList(5);

        sll.insertInLinkedList(234, 0);

        sll.insertInLinkedList(148, 2);
        sll.insertInLinkedList(65, 1);
        System.out.println(sll.head.value);
        System.out.println("size : "+ sll.size);
        sll.traverseSinglyLinkedList();
      //  sll.searchNodeSinglyLinkedList(124);
        sll.insertInLinkedList(458, 3);

        sll.traverseSinglyLinkedList();
        sll.deleteNodeFromSinglyLinkedList(2);
      //  sll.deleteNodeFromSinglyLinkedList(1000);

        System.out.println("\nafter delete operation..deletionOFNode");

        sll.traverseSinglyLinkedList();

        System.out.println("\ndeleting entire list..");
       // sll.deleteSLL();
        Thread.sleep(1000);
        sll.traverseSinglyLinkedList();
    }

}
