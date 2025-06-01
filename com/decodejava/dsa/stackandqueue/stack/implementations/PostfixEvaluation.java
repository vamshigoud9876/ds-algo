package com.decodejava.dsa.stackandqueue.stack.implementations;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

//https://www.geeksforgeeks.org/problems/evaluation-of-postfix-expression1735/1
//https://leetcode.com/problems/evaluate-reverse-polish-notation/
public class PostfixEvaluation {
    public int evaluate(String[] arr) {
        Set<String> operators = new HashSet<>();
        operators.add("^");
        operators.add("/");
        operators.add("*");
        operators.add("+");
        operators.add("-");

        Stack<String> stack = new Stack<>();
        for (String ch : arr) {
            if (operators.contains(ch)) {
                int operand2 = Integer.parseInt(stack.pop());
                int operand1 = Integer.parseInt(stack.pop());
                int result = switch (ch) {
                    case "^" -> operand1 ^ operand2;
                    case "/" -> operand1 / operand2;
                    case "*" -> operand1 * operand2;
                    case "+" -> operand1 + operand2;
                    case "-" -> operand1 - operand2;
                    default -> 0;
                };
                stack.push(String.valueOf(result));
            } else {
                stack.push(ch);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
