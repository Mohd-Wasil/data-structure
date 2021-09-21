package com.data.structure.stack;

import com.data.structure.stack.exception.StackOverFlowException;
import com.data.structure.stack.exception.StackUnderFlowException;

import java.util.Scanner;

public class StackMinElementConstantTime {

    public static void main(String[] args) {
        final Stack<Integer> integerStack = new Stack<>();
        final Stack<Integer> integerMinStack = new Stack<>();
        try {
            for (int i = 0; i < 7; i++) {
                System.out.println("enter integer to push to stack");
                Scanner scanner = new Scanner(System.in);
                Integer data = scanner.nextInt();
                integerStack.push(data);
                pushToMinStack(data, integerMinStack);
            }
            System.out.println("minimun elemetn in stack is " + integerMinStack.peek());
        } catch (StackOverFlowException e) {
            System.err.println("stack is full");
        } catch (StackUnderFlowException e) {
            System.err.println("stack is empty");
        }
    }


    private static void pushToMinStack(Integer data, Stack<Integer> integerMinStack) throws StackOverFlowException, StackUnderFlowException {
        if (integerMinStack.isEmpty()) {
            integerMinStack.push(data);
        }
        final Integer currentElement = integerMinStack.peek();
        if (currentElement > data) {
            integerMinStack.push(data); //new mininum
        } else {
            integerMinStack.push(currentElement);
        }
    }
}
