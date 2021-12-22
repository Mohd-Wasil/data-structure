package com.data.structure.v2.linkedlist.singly;

public class SinglyLinkedList {
    public Node head;
    public Node tail;
    public int size;

    public Node createSinglyLinkedList(int nodeValue) {
        //head = new Node();
        Node node = new Node();
        node.next = null;
        node.value = nodeValue;
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    public void insertInLinkedList(int nodeValue, int location) {
        Node newNode = new Node();
        newNode.value = nodeValue;
        if (head == null) {
            createSinglyLinkedList(nodeValue);
            return;
        } else if (location == 0) {//insert at beginning
            newNode.next = head;
            head = newNode;
        } else if (location >= size) { //insert at end
            newNode.next = null;
            tail.next = newNode;
            tail = newNode;
        } else {
            Node tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }
            Node nextNode = tempNode.next;
            tempNode.next = newNode;
            newNode.next = nextNode;
        }
        size++;
    }

    public void traverseSinglyLinkedList() {
        if (head == null) {
            System.out.println("list is empty...");
            return;
        }
        Node currentNode = head;
        System.out.print("traversing single linked list..\n");
        while (currentNode != null) {
            System.out.print(currentNode.value);
            if (currentNode.next != null) {
                System.out.print("->");
            }
            currentNode = currentNode.next;
        }
    }

    public boolean searchNodeSinglyLinkedList(int nodeValue) {
        System.out.println("\nsearching for nodeValue : " + nodeValue);
        if (head != null) {
            Node currentNode = head;
            while (currentNode != null) {
                if (currentNode.value == nodeValue) {
                    System.out.println("node found : " + currentNode + " value  : " + currentNode.value);
                    return true;
                }
                currentNode = currentNode.next;
            }
        }
        System.out.println("\n node NOT found :   value  : " + nodeValue);
        return false;
    }

    public void deleteNodeFromSinglyLinkedList(int location) {

        if (head == null) {
            System.out.println("singly linked list does not exist");
            return;
        }

        if (location == 0) { //delete from beginning of LL
            head = head.next;
            size--;
            if (size == 0) {
                //head = null; //not needed as head.next will be null
                tail = null;
            }
        } else if (location >= size) { //delete from end of LL
            Node currentNode = head;
            for (int i = 0; i < size - 2; i++) {
                currentNode = currentNode.next;
            }
            if (currentNode == head) {
                head = tail = null;
                size--;
                return;
            }
            currentNode.next = null;
            tail = currentNode;
            size--;

        } else { //delete from any position between LL
            Node currentNode = head;
            for (int i = 0; i < location - 1; i++) {
                currentNode = currentNode.next;
            }
            Node nextNode = currentNode.next;
            currentNode.next = nextNode.next;
            size--;
        }
    }



    public void deleteSLL() {
        System.out.println("\n deleting entitre LL");
        head = tail = null;
    }

}
