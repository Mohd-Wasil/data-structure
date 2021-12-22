package com.data.structure.v2.linkedlist.excercise;

import com.data.structure.v2.linkedlist.excercise.singly.LinkedList;
import com.data.structure.v2.linkedlist.excercise.singly.Node;

import java.util.HashSet;

public class RemoveDuplicateV2 {

    public static void main(String[] args) {
        //1->2->1->3
        //1->2->3
        LinkedList linkedList = new LinkedList();
        linkedList.createLinkedList(3);
        linkedList.insertNode(1);
        linkedList.insertNode(3);
        linkedList.insertNode(2);
        linkedList.insertNode(3);
        linkedList.insertNode(1);
        linkedList.insertNode(4);
        linkedList.insertNode(1);
        linkedList.insertNode(2);
        linkedList.traversalLL();
        removeDuplicate(linkedList);
        linkedList.traversalLL();
    }

    private static void removeDuplicate(LinkedList linkedList) {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        Node currentNode = linkedList.head;
        Node prevNode = null;
        while (currentNode != null ) {
            if (hashSet.contains(currentNode.value)) {
                //delete next node
                prevNode.next = currentNode.next;
                linkedList.size--;
                if(linkedList.tail == currentNode) {
                    linkedList.tail = prevNode;
                }
            } else {
                hashSet.add(currentNode.value);
                prevNode = currentNode;
            }
            currentNode = currentNode.next;
        }
        System.out.println("tail : "+ linkedList.tail.value  );
    }
}
