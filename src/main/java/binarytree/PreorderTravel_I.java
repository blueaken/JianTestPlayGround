package binarytree;

import type.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Author: blueaken
 * Date: 7/10/14 9:00 下午
 */
public class PreorderTravel_I {
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;

        Stack stack = new Stack();
        stack.push(root);
        TreeNode node;
        while (stack.size() > 0){
            root = (TreeNode)stack.pop();
            result.add(root.val);
            node = root.right;
            if (node != null) stack.push(node);
            node = root.left;
            if (node != null) stack.push(node);
        }

        return result;
    }

    public static void main(String[] args){
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);

        List<Integer> result = preorderTraversal(treeNode);
        for (Integer i: result){
            System.out.println(i);
        }

        System.out.println("*************");

        TreeNode treeNode2 = new TreeNode(3);
        treeNode2.left = new TreeNode(1);
        treeNode2.right = new TreeNode(2);

        result = preorderTraversal(treeNode2);
        for (Integer i: result){
            System.out.println(i);
        }
    }
}
