package com.data.structure.v2.linkedlist.excercise;

import com.data.structure.v2.linkedlist.excercise.singly.LinkedList;
import com.data.structure.v2.linkedlist.excercise.singly.Node;

public class PartitionList {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertNode(3);
        list.insertNode(4);
        list.insertNode(8);
        list.insertNode(7);
        list.insertNode(10);
        list.insertNode(12);
        list.insertNode(1);
        list.insertNode(6);
        list.traversalLL();
        LinkedList partitionList = partitionList(5, list);
        System.out.println("after partition..");
        partitionList.traversalLL();
        LinkedList partitionList2 = partitionListEasy(5, list);
        System.out.println("after partition..easy..");
        partitionList2.traversalLL();
    }


    private static LinkedList partitionListEasy(int x, LinkedList list) {
        Node currentNode = list.head;
        list.tail = currentNode;
        while (currentNode != null) {
            Node next = currentNode.next;
            if (x <= currentNode.value) {
                list.tail.next = currentNode;
                list.tail = currentNode;
            } else {
                currentNode.next = list.head;
                list.head = currentNode;
            }
            currentNode = next;
        }
        list.tail.next = null;
        return list;

    }

    private static LinkedList partitionList(int x, LinkedList list) {
        if (list.head == null) {
            System.out.println("list is empty!!");
            return null;
        }
        LinkedList leftList = new LinkedList();
        LinkedList rightList = new LinkedList();
        Node tempNode = list.head;

        while (tempNode != null) {
            if (tempNode.value >= x) {
                rightList.insertNode(tempNode.value);
            } else {
                leftList.insertNode(tempNode.value);
            }
            tempNode = tempNode.next;
        }
        leftList.tail.next = rightList.head;
        leftList.tail = rightList.tail;
        return leftList;
    }
}
