package lintcode.binarytree;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */

//abstract class Node {
//    public abstract int evaluate();
//    // define your fields here
//};

//class TreeNode extends Node {
//    String val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode (String val) {
//        this.val = val;
//    }
//
//    @Override
//    public int evaluate() {
//        return dfs(this);
//    }
//
//    private int dfs(TreeNode node) {
//        if (node.left == null && node.right == null) {
//            return Integer.valueOf(node.val);
//        }
//
//        String cur = node.val;
//        int res = 0;
//        if (cur.equals("+")) {
//            res = dfs(node.left) + dfs(node.right);
//        }
//        if (cur.equals("-")) {
//            res = dfs(node.left) - dfs(node.right);
//        }
//        if (cur.equals("*")) {
//            res = dfs(node.left) * dfs(node.right);
//        }
//        if (cur.equals("/")) {
//            res = dfs(node.left) / dfs(node.right);
//        }
//        return res;
//    }
//}

/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input
 * and returns the expression tree represnting it as a Node.
 */
/*
    - ref solution link https://leetcode.com/problems/design-an-expression-tree-with-evaluate-function/discuss/933995/Java-Stack-%2B-OOP
    - build the binary tree with a stack
    - dfs the tree and evaluate the result
 */
public class BuildExpressionTreeWithEvaluateFun_LE_1628 {
//    Node buildTree(String[] postfix) {
//        Set<String> operators = new HashSet<>();
//        operators.add("+");
//        operators.add("-");
//        operators.add("*");
//        operators.add("/");
//
//        Stack<TreeNode> stack = new Stack<>();
//        for (String s : postfix) {
//            TreeNode node = new TreeNode(s);
//            if (operators.contains(s)) {
//                node.right = stack.pop();
//                node.left = stack.pop();
//            }
//            stack.push(node);
//        }
//
//        return stack.pop();
//    }

    /**
     * Your TreeBuilder object will be instantiated and called as such:
     * TreeBuilder obj = new TreeBuilder();
     * Node expTree = obj.buildTree(postfix);
     * int ans = expTree.evaluate();
     */

    public static void main(String[] args) {
//        BuildExpressionTreeWithEvaluateFun_LE_1628 solution = new BuildExpressionTreeWithEvaluateFun_LE_1628();
//        String[] postfix = {"3", "4", "+", "2", "*", "7", "/"};//2
//        Node expTree = solution.buildTree(postfix);
//        System.out.println(expTree.evaluate());
    }
}