package com.data.structure.v2.linkedlist.excercise;

import com.data.structure.v2.linkedlist.excercise.singly.LinkedList;
import com.data.structure.v2.linkedlist.excercise.singly.Node;

public class SumLists {

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.createLinkedList(7);
        list1.insertNode(1);
        list1.insertNode(6);
        System.out.println("list1");
        list1.traversalLL();
        LinkedList list2 = new LinkedList();
        list2.createLinkedList(5);
        list2.insertNode(9);
        list2.insertNode(2);
        System.out.println("list2");
        list2.traversalLL();
        LinkedList list3 = sumLists(list1, list2);

        System.out.println("list3");
        list3.traversalLL();
    }

    public static LinkedList sumLists(LinkedList list1, LinkedList list2) {
        int no1 = findNumber(list1);
        int no2 = findNumber(list2);
        int no3 = no1 + no2;
        LinkedList list3 = new LinkedList();
        while (no3 != 0) {
            list3.insertNode(no3 % 10);
            no3 = no3 / 10;
        }
        return list3;
    }

    private static int findNumber(LinkedList list) {
        Node currentNode = list.head;
        int number = 0;
        int i = 0;
        while (currentNode != null) {
            number += currentNode.value * powerOf10(i);
            i++;
            currentNode = currentNode.next;
        }
        return number;
    }

    private static int powerOf10(int i) {
        if (i == 0)
            return 1;
        return 10 * powerOf10(--i);
    }
}
