package com.data.structure.v2.linkedlist.circulardoubly;

public class CircularDoublyLinkedList {

    DoublyNode head;
    DoublyNode tail;
    int size;

    public DoublyNode createCDLL(int nodeValue) {
        DoublyNode newNode = new DoublyNode();
        newNode.value = nodeValue;
        head = tail = newNode;
        newNode.next = newNode.prev = newNode;
        size = 1;
        return head;
    }

    public void insertNodeCDLL(int nodeValue, int location) {
        if (head == null) {
            createCDLL(nodeValue);
            return;
        }
        DoublyNode newNode = new DoublyNode();
        newNode.value = nodeValue;

        if (location == 0) {
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            head = newNode;
        } else if (location >= size - 1) {
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            tail = newNode;
        } else {
            DoublyNode currentNode = head;
            for (int i = 0; i < location - 1; i++) {
                currentNode = currentNode.next;
            }
            newNode.next = currentNode.next;
            newNode.prev = currentNode;
            currentNode.next.prev = newNode;
            currentNode.next = newNode;
        }
        size++;
    }

    public void traverseCDLL() {
        if (head == null) {
            System.out.println("\nCDLL doesnt exist!!");
            return;
        }
        DoublyNode currentNode = head;
        System.out.println("\n traversing Circular double ll");
        for (int i = 0; i < size; i++) {
            System.out.print(currentNode.value);
            if (i != size - 1) {
                System.out.print("->");
            }
            currentNode = currentNode.next;
        }
    }

    public void reverseTraverseCDLL() {
        if (head == null) {
            System.out.println("CDLL doesnt exist!!");
            return;
        }
        System.out.println("reverse traversing CDLL..");
        DoublyNode currentNode = tail;
        for (int i = 0; i < size; i++) {
            System.out.print(currentNode.value);
            if (i != size - 1) {
                System.out.print("<-");
            }
            currentNode = currentNode.prev;
        }
    }

    public boolean searchNode(int nodeValue) {
        boolean isFound = false;
        DoublyNode currentNode = head;
        for (int i = 0; i < size; i++) {
            if (currentNode.value == nodeValue) {
                System.out.println("\nnode value : " + nodeValue + " found at index : " + i);
                isFound = true;
                break;
            }
            currentNode = currentNode.next;
        }
        if (!isFound) {
            System.out.println("Node value not found : " + nodeValue);
        }
        return isFound;
    }

    public void deleteNodeCDLL(int location) {

        if (head == null) {
            System.out.println("CDLL doesnt exist!!");
            return;
        }
        System.out.println("deleting node at location : " + location);
        if (location == 0) {
            if (size == 1) {
                head.next = head.prev = null;
                head = tail = null;
            } else {
                head = head.next;
                head.prev = tail;
                tail.next = head;
            }
        } else if (location >= size - 1) {
            if (size == 1) {
                head.prev = tail.next = null;
                head = tail = null;
            }
            tail = tail.prev;
            tail.next = head;
            head.prev = tail;
        } else {
            DoublyNode currentNode = head;
            for (int i = 0; i < location - 1; i++) {
                currentNode = currentNode.next;
            }
            currentNode.next = currentNode.next.next;
            currentNode.next.prev = currentNode;
        }
        size--;
        System.out.println("node at location : " + location + " successfully deleted");
    }

    public void deleteCDLL() {
        if (head == null) {
            System.out.println("CDLL doesnt exist!!");
            return;
        }
        tail.next = null; //references first node
        DoublyNode currentNode = head;
        for (int i = 0; i < size; i++) {
            currentNode.prev = null;
            currentNode = currentNode.next;
        }
        head = tail = null;
        size = 0;
        System.out.println("deleted CDLL successfully!!!");
    }

}
