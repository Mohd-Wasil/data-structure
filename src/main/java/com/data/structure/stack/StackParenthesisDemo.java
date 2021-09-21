package com.data.structure.stack;

import com.data.structure.stack.exception.StackOverFlowException;
import com.data.structure.stack.exception.StackUnderFlowException;

import java.util.*;

public class StackParenthesisDemo {

    private static final Map<Character, Character> matchingParenthesisMap = new HashMap<>();
    private static final Set<Character> openingParenthesisSet = new HashSet<>();

    static {
        matchingParenthesisMap.put(')', '(');
        matchingParenthesisMap.put('}', '{');
        matchingParenthesisMap.put(']', '[');
        matchingParenthesisMap.put('>', '<');
        openingParenthesisSet.addAll(matchingParenthesisMap.values());
    }

    public static void main(String[] args) {
        String input;
        while (true) {
            System.out.println("enter a parenthesis input eg: (ABC) {DEF} [ <XYZ> (LMN)]})))");
            System.out.println("I will validate for you");
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();
            boolean value = hasMatchingParenthesis(input);
            System.out.println("input string : " + input);
            System.out.println("has matches parenthesis ? " + value);
            System.out.println("do you want to continue : T/F");
            scanner = new Scanner(System.in);
            if (scanner.nextLine().equalsIgnoreCase("F")) {
                System.out.println("bye bye..");
                break;
            }
        }
    }

    private static boolean hasMatchingParenthesis(String input) {
        Stack<Character> inputOpeningParenthesisStack = new Stack<>();
        try {
            for (int i = 0; i < input.length(); i++) {
                Character ch = input.charAt(i);
                if (openingParenthesisSet.contains(ch)) {
                    inputOpeningParenthesisStack.push(ch);
                }
                if (matchingParenthesisMap.containsKey(ch)) {
                    Character data = inputOpeningParenthesisStack.pop();
                    if (matchingParenthesisMap.get(ch) != data) {
                        return false;
                    }
                }
            }
            return inputOpeningParenthesisStack.isEmpty();
        } catch (StackOverFlowException e) {
            System.err.println("stack is full" + e.getMessage());
        } catch (StackUnderFlowException e) {
            System.err.println("stack is empty" + e.getMessage());
        }
        return false;
    }
}
