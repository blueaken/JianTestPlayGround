package lintcode.stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 */
 class Node {
     char val;
     Node left;
     Node right;
     Node() {this.val = ' ';}
     Node(char val) { this.val = val; }
     Node(char val, Node left, Node right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

public class BuildBinaryExpressionTreeFromInfixExpression_LE_1597_P1 {
    /*
        - convert infix string to postfix then build the expression tree followed the hint
        - ref the following link for the algorithm & example
        - https://www.techiedelight.com/zh/convert-infix-to-postfix-expression/
    */

    String operands = "+-*/";

    public Node expTree(String s) {
        String postfixStr = convertToPostfix(s);
        Stack<Node> stack = new Stack<>();
        for (int i = 0; i < postfixStr.length(); i++) {
            char cur = postfixStr.charAt(i);
            Node node = new Node(cur);
            if (operands.indexOf(cur) >= 0) {
                node.right = stack.pop();
                node.left = stack.pop();
            }
            stack.push(node);
        }
        return stack.pop();
    }

    private String convertToPostfix(String infixStr) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < infixStr.length(); i++) {
            char cur = infixStr.charAt(i);
            //ref the link above, handle operands/'('/')'/numbers 4 different cases with the help of a stack
            if (operands.indexOf(cur) >= 0) {
                while (!stack.isEmpty() && isCurLessThanOrEqualToStackPeek(cur, stack.peek())) {
                    sb.append(stack.pop());
                }
                stack.push(cur);
            } else if (cur == '(') {
                stack.push(cur);
            } else if (cur == ')') {
                while (stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop(); //pop the '('
            } else { //number case
                sb.append(cur);
            }
        }
        //append the rest of the stack to the string
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    private boolean isCurLessThanOrEqualToStackPeek(char cur, char peek) {
        Set<Character> less = new HashSet<>();
        less.add('+');
        less.add('-');

        Set<Character> higher = new HashSet<>();
        higher.add('*');
        higher.add('/');

        return less.contains(cur) && less.contains(peek)
                || higher.contains(cur) && higher.contains(peek)
                || less.contains(cur) && higher.contains(peek);
    }

    public static void main(String[] args) {
        BuildBinaryExpressionTreeFromInfixExpression_LE_1597_P1 solution = new BuildBinaryExpressionTreeFromInfixExpression_LE_1597_P1();
//        String input = "3*4-2*5";
//        String input = "2-3/(5*2)+1";
        String input = "2-3*4+1";
        solution.expTree(input);

//        TreeNodeUtil.printTree(solution.expTree(input));
    }
}
