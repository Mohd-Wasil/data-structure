package com.data.structure.v2.linkedlist.doubles;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.createDLL(123);
        System.out.println("DLL head : "+ dll.head.value + " dll next : "+ dll.head.next);
        dll.deleteNode(0);

        dll.traverseDLL();
        dll.insertDll(101, 0);
        dll.traverseDLL();
        dll.insertDll(201,1);
        dll.traverseDLL();
        dll.insertDll(901,10);
        dll.reverseTraverseDLL();
        dll.searchNode(921);
        dll.traverseDLL();
        dll.deleteNode(2);
        dll.traverseDLL();
        dll.reverseTraverseDLL();
        dll.deleteDLL();
        dll.traverseDLL();
    }
}
