package com.data.structure.v2.linkedlist.circularsingly;

public class CircularSinglyLinkedList {

    public Node head;
    public Node tail;
    public int size;

    public Node createCircularSinglyLinkedList(int nodeValue) {
        Node node = new Node();
        node.value = nodeValue;
        node.next = node; // first element; reference to itself for circular LL;
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    public void insertCSLL(int nodeValue, int location) {
        if (head == null) {
            System.out.println("circular ll do not exist..");
            createCircularSinglyLinkedList(nodeValue);
            return;
        }
        Node newNode = new Node();
        newNode.value = nodeValue;
        if (location == 0) { //insert in the beginning
            newNode.next = head;
            head = newNode;
            tail.next = head; //last node points to first node
        } else if (location >= size) { //insert at the end..
            tail.next = newNode;
            tail = newNode;
            tail.next = head; //last node next's ref should point to first node
        } else { //insert at specified location
            Node tempNode = head;
            for (int i = 0; i < location - 1; i++) { //location -4
                tempNode = tempNode.next;
            }
            newNode.next = tempNode.next;
            tempNode.next = newNode;
        }
        size++;
    }

    public void traverseCSLL() {
        System.out.println("\ntraversing CSLL...");
        if (head == null) {
            System.out.println("CSLL doesnot exist");
            return;
        }
        Node currentNode = head;
        for (int i = 0; i < size; i++) {
            System.out.print(currentNode.value);
            currentNode = currentNode.next;
            if (i < size - 1) {
                System.out.print("->");
            }
        }
    }

    public void traverseCSLLInfinite() {
        if (head == null) {
            System.out.println("CSLL doesnot exist");
            return;
        }
        Node currentNode = head;
        while (currentNode.next != null) {
            System.out.print(currentNode.value + " ->");
            currentNode = currentNode.next;
        }
    }

    public boolean searchNodeCSLL(int nodeValue) {
        boolean isFound = false;
        if (head == null) {
            System.out.println("CSLL doesn't exist!!");
            isFound = false;
        } else {
            Node currentNode = head;
            for (int i = 0; i < size; i++) {
                if (currentNode.value == nodeValue) {
                    System.out.println("node found : " + nodeValue + " at location: " + i);
                    isFound = true;
                    break;
                }
                currentNode = currentNode.next;
            }
        }
        System.out.println(isFound ? "Node found !!" : "Node not found!!!");
        return isFound;
    }

    public void deleteNodeCSLL(int location) {
        if (head == null) {
            System.out.println("CSLL doesn't exist!!");
            return;
        }
        if (location == 0) { //delete from beginning
            head = head.next;
            tail.next = head;
            size--;
            if (size == 0) {
                head.next = null;
                head = tail = null;
            }
        } else if (location >= size) { //delete from end

            Node tempNode = head;
            for (int i = 0; i < size - 2; i++) {
                tempNode = tempNode.next;
            }
            if(tempNode == head) {
                head.next = null;
                head = tail = null;
                size--;
                return;
            }
            tempNode.next.next = null;
            tail = tempNode;
            tail.next = head;
            size--;
        } else if (location < size) {
            Node tempNode = head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            size--;
        }
    }

    public void deleteEntireCSLL() {
        if(head == null) {
            System.out.println("CSLL does not exist!!!!");
        }
        System.out.println("deleting entire CSLL..");
        head= null;
        tail.next = null;
        tail = null;
        System.out.println("CSSL successfully deleted...");
    }
}
