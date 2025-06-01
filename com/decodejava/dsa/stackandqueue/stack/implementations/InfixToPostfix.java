package com.decodejava.dsa.stackandqueue.stack.implementations;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class InfixToPostfix {
    public static String infixToPostfix(String s) {
        Map<Character, Integer> precedence = new HashMap<>();
        precedence.put('^', 3);//highest priority
        precedence.put('/', 2);
        precedence.put('*', 2);
        precedence.put('+', 1);
        precedence.put('-', 1);//lowest priority
        precedence.put('(', 0);//lowest priority - technically, highest priority but for our easiness in comparing and stopping taking as 1.

        Stack<Character> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!isOperand(ch)) {
                if (ch == ')') {
                    while (!stack.isEmpty()) {
                        char popped = stack.pop();
                        if (popped == '(') {
                            break;
                        }
                        ans.append(popped);
                    }
                } else if (ch == '(') {
                    stack.push(ch);
                } else {
                    while (!stack.isEmpty() && precedence.get(stack.peek()) >= precedence.get(ch)) {
                        ans.append(stack.pop());
                    }
                    stack.push(ch);
                }
            } else {
                ans.append(ch);
            }
        }
        while (!stack.isEmpty())
            ans.append(stack.pop());

        return ans.toString();
    }

    private static boolean isOperand(char ch) {
        return (ch >= 'a' && 'z' >= ch) || ('A' <= ch && 'Z' >= ch) || ('0' <= ch && '9' >= ch);
    }
}
