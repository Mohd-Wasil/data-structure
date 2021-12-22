package com.data.structure.v2.queues.linearqueue;

public class Main {
    public static void main(String[] args) {
        QueueArray  queueAray = new QueueArray(3);
        System.out.println("queue full "+ queueAray.isFull());
        System.out.println("queue empty "+ queueAray.isEmpty());
        queueAray.enQueue(1);
        queueAray.enQueue(2);
        queueAray.enQueue(3);
        queueAray.enQueue(4);
        System.out.println("peek : "+queueAray.peek());
        System.out.println("peek : "+queueAray.peek());
        System.out.println("value dequeue :" +queueAray.dequeue());
        System.out.println("value dequeue :" +queueAray.dequeue());
        System.out.println("value dequeue :" +queueAray.dequeue());
        System.out.println("value dequeue :" +queueAray.dequeue());
        System.out.println("queue deleting..");
        queueAray.delete();

    }
}


