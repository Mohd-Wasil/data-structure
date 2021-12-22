package com.data.structure.v2.linkedlist.excercise;

import com.data.structure.v2.linkedlist.excercise.singly.LinkedList;
import com.data.structure.v2.linkedlist.excercise.singly.Node;

public class IntersectionList {

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.insertNode(3);
        list1.insertNode(1);
        list1.insertNode(5);
        list1.insertNode(9);
        LinkedList list2 = new LinkedList();
        list2.insertNode(2);
        list2.insertNode(4);
        list2.insertNode(6);
        addIntersectedNode(list1, list2, 15);
        addIntersectedNode(list1, list2, 13);
        addIntersectedNode(list1, list2, 32);
        //not mandatory... but req to maintain size attr
       /* list2.insertNode(2);
        list2.insertNode(1);*/
        System.out.println("traversing list 1 , insert executed : ");
        list1.traversalLL();
        System.out.println("traversing list 2, should be same ");
        list2.traversalLL();
        identifyIntersectionNode(list1, list2);
        Node intersectedNode = identifyIntersectionNodePerformant(list1, list2);
        System.out.println("intersectNode performant : " + intersectedNode.value);
    }

    public static Node getKthNode(Node currentNode, int k) {
        while (k > 0 && currentNode != null) {
            currentNode = currentNode.next;
            k--;
        }
        return currentNode;
    }

    private static Node identifyIntersectionNodePerformant(LinkedList list1, LinkedList list2) {
        if (list1.head == null || list2.head == null) {
            return null;
        }
        if (list1.tail != list2.tail) {
            return null;
        }
        Node shorter;
        Node longer;
        if (list1.size > list2.size) {
            longer = list1.head;
            shorter = list2.head;
        } else {
            shorter = list1.head;
            longer = list2.head;
        }
        longer = getKthNode(longer, Math.abs(list1.size - list2.size));
        while (shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }
        return shorter; ///any one

    }

    private static void identifyIntersectionNode(LinkedList list1, LinkedList list2) {
        Node tempNodeFromList1 = list1.head;
        while (tempNodeFromList1 != null) {
            Node tempNodeFromList2 = list2.head;
            while (tempNodeFromList2 != null) {
                if (tempNodeFromList1 == tempNodeFromList2) {
                    System.out.println("intersection node : " + tempNodeFromList1.value);
                    return;
                }
                tempNodeFromList2 = tempNodeFromList2.next;
            }
            tempNodeFromList1 = tempNodeFromList1.next;
        }
        System.out.println("intersection node not available..");
    }

    private static void addIntersectedNode(LinkedList list1, LinkedList list2, int nodeValue) {
        Node newNode = new Node();
        newNode.value = nodeValue;
        //newNode.next = null;
        list1.tail.next = newNode;
        list1.tail = newNode;
        list2.tail.next = newNode;
        list2.tail = newNode;
        list1.size++;
        list2.size++;
    }
}
