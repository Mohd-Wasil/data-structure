package com.data.structure.v2.stack.viaarray;

public class Main {
    public static void main(String[] args) {
        Stack newStack = new Stack(4);
        System.out.println("isEmpty :" + newStack.isEmpty());
        System.out.println("isFull :" + newStack.isFull());
        newStack.push(12);
        newStack.push(13);
        newStack.push(14);
        newStack.push(15);
        newStack.push(16);//full as size is 4 only

        newStack.peek();
        newStack.peek();

        newStack.pop();
        newStack.pop();
        newStack.pop();
        newStack.pop(); //empty
        newStack.peek();
        newStack.delete();
        newStack.push(3);


    }
}
