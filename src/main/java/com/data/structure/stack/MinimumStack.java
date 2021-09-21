package com.data.structure.stack;

import com.data.structure.stack.exception.StackOverFlowException;
import com.data.structure.stack.exception.StackUnderFlowException;

import java.util.Scanner;

public class MinimumStack {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minimumStack = new Stack<>();

    public void push(Integer data) throws StackOverFlowException, StackUnderFlowException {
        Integer min = data;
        if (!minimumStack.isEmpty()) {
            if (min > minimumStack.peek()) {
                min = minimumStack.peek();
            }
        }
        stack.push(data);
        minimumStack.push(min);
    }

    public Integer pop() throws StackUnderFlowException {
        minimumStack.pop();
        return stack.pop();
    }

    public Integer getMinimum() throws StackUnderFlowException {
        return minimumStack.peek();
    }

    public static void main(String[] args) {
        MinimumStack mystack = new MinimumStack();
        try {
            for (int i = 0; i < 7; i++) {
                System.out.println("enter integer to push to stack");
                Scanner scanner = new Scanner(System.in);
                Integer data = scanner.nextInt();
                mystack.push(data);
            }
            System.out.println("minimum element in stack is O(1)" + mystack.getMinimum());
            for (int i = 0; i < 7; i++) {

                System.out.println(mystack.pop());
            }
        } catch (StackOverFlowException e) {
            System.err.println("stack is full");
        } catch (StackUnderFlowException e) {
            System.err.println("stack is empty");
        }
    }
}
