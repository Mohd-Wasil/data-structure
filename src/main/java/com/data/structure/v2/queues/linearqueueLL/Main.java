package com.data.structure.v2.queues.linearqueueLL;

public class Main {
    public static void main(String[] args) {
        QueueUsingLinkedList qll = new QueueUsingLinkedList();
        qll.enQueue(12);
        qll.enQueue(13);
        qll.enQueue(14);
        qll.enQueue(15);
        System.out.println("peek value : "+ qll.peek());
        System.out.println("peek value : "+ qll.peek());

        System.out.println("dequeue value : "+qll.deQueue());
        System.out.println("dequeue value : "+qll.deQueue());
        System.out.println("dequeue value : "+qll.deQueue());
        System.out.println("dequeue value : "+qll.deQueue());
        System.out.println("dequeue value : "+qll.deQueue());

    }
}

