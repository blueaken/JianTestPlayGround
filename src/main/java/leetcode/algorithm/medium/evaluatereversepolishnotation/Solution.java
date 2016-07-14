package leetcode.algorithm.medium.evaluatereversepolishnotation;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by jshe18 on 11/10/15.
 */
public class Solution {
    public static int evalRPN(String[] tokens) {
        Set<String> opr = new HashSet<String>(){{
            add("+");
            add("-");
            add("*");
            add("/");
        }};
        Stack<Integer> stack = new Stack<>();

        if (tokens==null) return Integer.MIN_VALUE;
        for (String s : tokens){
            if (!opr.contains(s)) {
                stack.push(Integer.parseInt(s));
            }else {
                stack.push(eval(stack.pop(), stack.pop(), s));
            }
        }
        return stack.pop();
    }

    private static int eval(int op2, int op1, String operator){
        switch (operator){
            case "+":
                return op1+op2;
            case "-":
                return op1-op2;
            case "*":
                return op1*op2;
            default:
                return op1/op2;
        }
    }

    public static void main(String[] args){
        String[] input = {"8", "1", "2", "+", "2", "*", "-"};
        System.out.println(evalRPN(input));
    }
}
