package com.data.structure.v2.stack.vialinkedlist;

public class Main {

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(11);
        stack.push(12);

        System.out.println("peek : : " +stack.peek());
        System.out.println("peek : : " +stack.peek());

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.deleteStack();

        stack.push(74);

    }
}


