package com.data.structure.v2.linkedlist.doubles;

public class DoublyLinkedList {

    DoublyNode head;
    DoublyNode tail;
    int size;

    public DoublyNode createDLL(int nodeValue) {
        DoublyNode newNode = new DoublyNode();
        newNode.value = nodeValue;
        newNode.next = newNode.prev = null;
        head = newNode;
        tail = newNode;
        size = 1;
        return newNode;
    }

    public void insertDll(int nodeValue, int location) {
        if (head == null) {
            createDLL(nodeValue);
            return;
        }
        DoublyNode newNode = new DoublyNode();
        newNode.value = nodeValue;
        if (location == 0) { //insert at beginning
            newNode.prev = null;
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else if (location >= size) { //insert at end
            DoublyNode tempNode = head;
            for (int i = 0; i < size - 1; i++) {
                tempNode = tempNode.next;
            }
            newNode.next = null;
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        } else {
            DoublyNode currentNode = head;
            for (int i = 0; i < location - 1; i++) { //insert at specified location..
                currentNode = currentNode.next;
            }
            newNode.prev = currentNode;
            newNode.next = currentNode.next;
            currentNode.next = newNode;
            newNode.next.prev = newNode;
        }
        size++;
    }


    public void traverseDLL() {
        if (head == null) {
            System.out.println("DLL doesnt exist!!");
            return;
        }
        System.out.println("\ntraversing DLL... forward");
        DoublyNode currentNode = head;
        for (int i = 0; i < size; i++) {
            System.out.print(currentNode.value);
            if (i != size - 1) {
                System.out.print("->");
            }
            currentNode = currentNode.next;
        }
    }

    public void reverseTraverseDLL() {
        if (head == null) {
            System.out.println("DLL doesnt exist!!");
            return;
        }
        System.out.println("\nprint nodes reverse...");
        DoublyNode currentNode = tail;
        for (int i = 0; i < size; i++) {
            System.out.print(currentNode.value);
            if (i != size - 1) {
                System.out.print("<-");
            }
            currentNode = currentNode.prev;
        }
       /* while(currentNode.prev !=null){
            System.out.print(currentNode.value +" ");
            currentNode = currentNode.prev;
        }
        System.out.print(currentNode.value +" ");*/
    }

    public boolean searchNode(int nodeValue) {
        boolean isFound = false;
        if (head == null) {
            System.out.println("DLL doesnt exist!!");

        } else {
            DoublyNode currentNode = head;
            for (int i = 0; i < size; i++) {
                System.out.println(currentNode);
                if (currentNode.value == nodeValue) {
                    System.out.println("value " + nodeValue + " found at index location : " + i);
                    isFound = true;
                    break;
                }
                currentNode = currentNode.next;
            }
            if (!isFound) {
                System.out.println("node not present in DLL!!");
            }
        }
        return isFound;
    }

    public void deleteNode(int location) {

        if (head == null || location < 0) {
            System.out.println(" DLL doesnt exist!! or location not valid , enter positive integer [0-n]");
            return;
        }
        System.out.println("\n deleting DLL at location :  " + location);
        if (location == 0) { //delete from beginning
            if (size == 1) {
                head = tail = null;
                return;
            }
            head = head.next;
            head.prev = null;

        } else if (location >= size - 1) { //delete from end
            if (size == 1) {
                head = tail = null;
                return;
            }
            tail = tail.prev;
            tail.next = null;
        } else {
            DoublyNode currentNode = head;
            for (int i = 0; i < location - 1; i++) { //delete at specified location
                currentNode = currentNode.next;
            }
            currentNode.next = currentNode.next.next;
            currentNode.next.prev = currentNode;
            /*DoublyNode nextNode = currentNode.next; //both are ok
            currentNode.next = nextNode.next;
            nextNode.next.prev = currentNode;*/

        }
        size--;
    }

    public void deleteDLL() {
        DoublyNode currentNode = head;
        for (int i = 0; i < size; i++) {
            currentNode.prev = null;
            currentNode = currentNode.next;
        }
        head = tail = null;
        System.out.println("the dll has been delete!!!");
    }
}
