package com.data.structure.v2.queues.linearqueueLL;

import javax.persistence.criteria.CriteriaBuilder;

public class QueueUsingLinkedList {

    LinkedList list;

    //create queue
    public QueueUsingLinkedList() {
        list = new LinkedList();
        System.out.println("Queue is successfully created.. var size");
    }

    public boolean isEmpty() {
        return list.head == null;
    }

    public void enQueue(int value) {
        list.insertAtEnd(value);
        System.out.println("value successfully inserted to queue : " + value);
    }

    public int deQueue() {
        if (isEmpty()) {
            System.out.println("queue is empty..");
            return Integer.MIN_VALUE;
        }
        int value = list.deleteFromBeginning();
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("queue is empty..");
            return Integer.MIN_VALUE;
        }
        return list.head.value;
    }

    public void deleteQueue() {
        list.head = list.tail = null;
        list = null;
        System.out.println("queue is deleted");
    }
}
