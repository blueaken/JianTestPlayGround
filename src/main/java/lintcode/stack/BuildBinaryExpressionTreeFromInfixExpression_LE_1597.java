package lintcode.stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import type.TreeNode;

/*
    - convert infix string to postfix then build the expression tree followed the hint
*/
public class BuildBinaryExpressionTreeFromInfixExpression_LE_1597 {
    String operands = "+-*/";

    public TreeNode expTree(String s) {
        //postfix str has no ambiguous meaning, convert it first
        String postfixStr = convert(s);

        //build the tree from postfix str
        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0; i < postfixStr.length(); i++) {
            char cur = postfixStr.charAt(i);
            TreeNode node = new TreeNode(cur);
            if (operands.indexOf(cur) >= 0) {
                node.right = stack.pop();
                node.left = stack.pop();
            }
            stack.push(node);
        }
        return stack.pop();
    }

    private String convert(String infixStr) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < infixStr.length(); i++) {
            char cur = infixStr.charAt(i);
            if (operands.indexOf(cur) >= 0) {
                //1. while cur is less or equal precedence to the stack top then pop
                //2. push the next operator into stack
                while (stack.size() > 0 && isCurLessOrEqualStackTop(cur, stack.peek())) {
                    sb.append(stack.pop());
                }
                stack.push(cur);
            } else if (cur == '(') {
                //if '(' just append to the postfix str
                stack.push(cur);
            } else if (cur == ')') {
                while (stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                //pop the '(' from stack
                stack.pop();
            } else {
                //if digits just append to the postfix str
                sb.append(cur);
            }
        }

        //remaining operators should be popped and appended to SB
        while (stack.size() > 0) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    private boolean isCurLessOrEqualStackTop(char cur, char top) {
        Set<Character> operandSetLess = new HashSet<>();
        operandSetLess.add('+');
        operandSetLess.add('-');

        Set<Character> operandSetHigher = new HashSet<>();
        operandSetHigher.add('*');
        operandSetHigher.add('/');

        return operandSetLess.contains(cur) && operandSetLess.contains(top)
                || operandSetHigher.contains(cur) && operandSetHigher.contains(top)
                || operandSetLess.contains(cur) && operandSetHigher.contains(top);
    }

    public static void main(String[] args) {
        BuildBinaryExpressionTreeFromInfixExpression_LE_1597 solution = new BuildBinaryExpressionTreeFromInfixExpression_LE_1597();
        String infixStr = "3*4-2*5";
        solution.expTree(infixStr);
    }
}
