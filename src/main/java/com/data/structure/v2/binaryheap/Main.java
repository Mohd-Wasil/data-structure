package com.data.structure.v2.binaryheap;

public class Main {

    private static  final String MIN_HEAP = "Max";
    private static  final String MAX_HEAP = "Max";
    public static void main(String[] args) {
        BinaryHeap binaryHeap = new BinaryHeap(10);
        binaryHeap.peek();
        binaryHeap.insert(5, MIN_HEAP);
        binaryHeap.insert(10, MIN_HEAP);
        binaryHeap.insert(20, MIN_HEAP);
        binaryHeap.insert(30, MIN_HEAP);
        binaryHeap.insert(40, MIN_HEAP);
        binaryHeap.insert(50, MIN_HEAP);
        binaryHeap.insert(60, MIN_HEAP);
        System.out.println("levle order traversal 1");
        binaryHeap.levelOrder();
        //binaryHeap.insert(1, MIN_HEAP);
       // binaryHeap.extractHeadOfBP(MIN_HEAP);
        System.out.println("levle order traversal 2");
        binaryHeap.levelOrder();
        while(!binaryHeap.isEmpty()) {
            binaryHeap.extractHeadOfBP(MIN_HEAP);
        }

    }
}
