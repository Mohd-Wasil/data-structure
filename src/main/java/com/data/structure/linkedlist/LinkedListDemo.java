package com.data.structure.linkedlist;

public class LinkedListDemo {

    public static void main(String[] args) {
        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();
        for (int i = 0; i < 100; i++) {
            addNode(i, linkedList);
        }
        traverseNode(linkedList);
        System.out.println("length of ll : " + linkedList.getCounter()); //O(1)
        for (int i = 0; i < 30; i++) {
            Node<Integer> head = popFirstElement(linkedList);
            System.out.println("popped element is : " + head);
        }
        System.out.println("length of ll : " + linkedList.getCounter()); //O(1)

    }

    private static Node<Integer> popFirstElement(CustomLinkedList<Integer> linkedList) {

        Node<Integer> head = linkedList.getHead();
        linkedList.setHead(head.getNext());
        linkedList.setCounter(linkedList.getCounter() - 1);
        return head;

    }

    private static void traverseNode(CustomLinkedList<Integer> linkedList) {
        if (linkedList.getHead() == null) {
            System.out.println("data is empty");
        } else {
            Node<Integer> currentNode = linkedList.getHead();
            System.out.println("data is " + currentNode);
            while (currentNode != null) {
                currentNode = currentNode.getNext();
                System.out.println("data is " + currentNode);
            }
        }

    }

    private static void addNode(int i, CustomLinkedList<Integer> linkedList) {
        if (linkedList.getHead() == null) {
            linkedList.setHead(new Node<>(i));
        } else {
            Node<Integer> currentNode = linkedList.getHead();
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(new Node<Integer>(i));
        }
        linkedList.setCounter(linkedList.getCounter() + 1);
    }
}
