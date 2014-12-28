package binarytree;

import type.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by jianshen on 12/28/14.
 */
/*
* pre order binary tree no recurring solution attack from myself
 */
public class PreorderTravel_I_self {
    public static void main(String[] args){
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);

        List<Integer> result = preorderTraversal(treeNode);
        for (Integer i: result){
            System.out.println(i);
        }
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();

        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode node;

        while (stack.size()!=0){
            node = stack.pop();
            result.add(node.val);
            if (node.right!=null){
                stack.push(node.right);
            }

            if(node.left!=null){
                stack.push(node.left);
            }
        }

        return result;
    }
}
