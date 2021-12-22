package com.data.structure.v2.linkedlist.excercise;

import com.data.structure.v2.linkedlist.excercise.singly.LinkedList;
import com.data.structure.v2.linkedlist.excercise.singly.Node;

public class NthToLastLL {

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.createLinkedList(12);
        ll.insertNode(13);
        ll.insertNode(14);
        ll.insertNode(15);
        ll.insertNode(16);
        ll.insertNode(17);
        ll.insertNode(18);
        ll.traversalLL();
        System.out.println("method 1 : with size");
        nthToLastElement(ll, 2);
        System.out.println("method 2 : without size");
        nthToLastWithoutSize(ll, 2);
    }

    private static void nthToLastWithoutSize(LinkedList ll, int n) {
        Node pointer1 = ll.head;
        Node pointer2 = ll.head;
        for (int i = 0; i < n; i++) {
            if (pointer2 == null) { //in case n is large value
                return;
            }
            pointer2 = pointer2.next;
        }
        while (pointer2 != null) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        System.out.println("element " + n + "th last : " + pointer1.value);
    }


    private static void nthToLastElement(LinkedList ll, int n) {
        if (n <= ll.size && n > 0) {
            int location = ll.size - n;
            Node currentNode = ll.head;
            for (int i = 0; i < location; i++) {
                currentNode = currentNode.next;
            }
            System.out.println("current Node from nth last : " + currentNode.value);
        }
    }
}
