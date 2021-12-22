package com.data.structure.v2.linkedlist.excercise;

import com.data.structure.v2.linkedlist.excercise.singly.LinkedList;
import com.data.structure.v2.linkedlist.excercise.singly.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoveDuplicate {

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
        List<Integer> duplicateLocation = identifyDuplicateLocation(linkedList);
        if (!duplicateLocation.isEmpty()) {
            int i = 0;
            for (int location : duplicateLocation) {
                removeDuplicate(i > 0 ? location - i : location, linkedList);

                i++;
            }
        }
        linkedList.traversalLL();
    }

    private static void removeDuplicate(int duplicateLocation, LinkedList linkedList) {
        Node tempNode = linkedList.head;
        for (int i = 0; i < duplicateLocation - 1; i++) {
            tempNode = tempNode.next;
        }
        tempNode.next = tempNode.next.next;
        linkedList.size--;

    }

    private static List<Integer> identifyDuplicateLocation(LinkedList linkedList) {
        List<Integer> duplicateLocations = new ArrayList<>();
        Map<Integer, Integer> elementCount = new HashMap<>();
        Node currentNode = linkedList.head;
        Node prevNode = currentNode;
        for (int i = 0; i < linkedList.size; i++) {
            if (elementCount.get(currentNode.value) == null) {
                elementCount.put(currentNode.value, 1);
            } else {
                duplicateLocations.add(i);
            }
            currentNode = currentNode.next;
        }
        System.out.println("duplicaet locations: " + duplicateLocations);
        return duplicateLocations;
    }
}
