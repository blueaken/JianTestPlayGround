package lintcode.binarytree;

import java.util.Stack;

/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */
//abstract class Node {
//    public abstract int evaluate();
//    // define your fields here
//    public static Node create (String val) {
//        switch (val) {
//            case "+":
//                return new AddNode();
//            case "-":
//                return new SubtractNode();
//            case "*":
//                return new MultipleNode();
//            case "/":
//                return new DivideNode();
//            default:
//                return new NumberNode(val);
//        }
//    }
//}
//
//abstract class OperatorNode extends Node{
//    protected Node left;
//    protected Node right;
//
//    public void setLeft(Node left) {
//        this.left = left;
//    }
//    public void setRight(Node right) {
//        this.right = right;
//    }
//}
//
//class AddNode extends OperatorNode {
//    public int evaluate() {
//        return left.evaluate() + right.evaluate();
//    }
//}
//
//class SubtractNode extends OperatorNode {
//    public int evaluate() {
//        return left.evaluate() - right.evaluate();
//    }
//}
//
//class MultipleNode extends OperatorNode {
//    public int evaluate() {
//        return left.evaluate() * right.evaluate();
//    }
//}
//
//class DivideNode extends OperatorNode {
//    public int evaluate() {
//        return left.evaluate() / right.evaluate();
//    }
//}
//
//class NumberNode extends Node {
//    String val;
//
//    NumberNode (String val) {
//        this.val = val;
//    }
//
//    public int evaluate() {
//        return Integer.valueOf(this.val);
//    }
//}

/*
- ref solution link https://leetcode.com/problems/design-an-expression-tree-with-evaluate-function/discuss/933995/Java-Stack-%2B-OOP
- build the binary tree with a stack
- dfs the tree and evaluate the result
- For the follow up question -
  Follow up: Could you design the expression tree such that it is more modular? For example, is your design able to support additional operators without making changes to your existing evaluate implementation?
- refactor the code with factory mode to make the solution more modular?
- ref - https://leetcode.com/problems/design-an-expression-tree-with-evaluate-function/discuss/1209901/Java-Factory-method-pattern
*/
public class Test {
//    Node buildTree(String[] postfix) {
//        Stack<Node> stack = new Stack<>();
//        for (int i = 0; i < postfix.length; i++) {
//            String cur = postfix[i];
//            Node node = Node.create(cur);
//            if (node instanceof NumberNode) {
//                stack.push(node);
//            } else if (node instanceof OperatorNode) {
//                OperatorNode n = (OperatorNode) node;
//                n.setRight(stack.pop());
//                n.setLeft(stack.pop());
//                stack.push(n);
//            }
//        }
//        return stack.pop();
//    }
//
//    /**
//     * Your TreeBuilder object will be instantiated and called as such:
//     * TreeBuilder obj = new TreeBuilder();
//     * Node expTree = obj.buildTree(postfix);
//     * int ans = expTree.evaluate();
//     */
//
//    public static void main(String[] args) {
//        Test solution = new Test();
//        String[] postfix = {"3", "4", "+", "2", "*", "7", "/"};//2
//        Node expTree = solution.buildTree(postfix);
//        System.out.println(expTree.evaluate());
//    }
}

