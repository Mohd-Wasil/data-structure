package com.data.structure.v2.queues.circularqueue;

public class Main {
    public static void main(String[] args) {
        CircualarQueue newCQ = new CircualarQueue(3);
        System.out.println("queue is empty: "+newCQ.isEmpty());
        System.out.println("queue is full: "+newCQ.isFull());
        newCQ.enQueue(10);
        newCQ.enQueue(11);
        newCQ.enQueue(12);
        System.out.println("peek : " +newCQ.peek());
        System.out.println("peek : " +newCQ.peek());


        System.out.println("value dequeued : " +newCQ.deQueue());
        System.out.println("value dequeued : " +newCQ.deQueue());
        newCQ.enQueue(13);
        System.out.println("value dequeued : " +newCQ.deQueue());
        System.out.println("value dequeued : " +newCQ.deQueue());
        System.out.println("value dequeued : " +newCQ.deQueue());
        System.out.println("peek : " +newCQ.peek());
        System.out.println("deleting queue : " );
        newCQ.delete();

    }
}

