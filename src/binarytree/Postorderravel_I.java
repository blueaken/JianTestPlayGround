package binarytree;

import type.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Author: blueaken
 * Date: 7/10/14 10:25 下午
 */
public class Postorderravel_I {

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack stack = new Stack();

        while (!stack.isEmpty() || root != null){
            if (root != null){
                stack.push(root);
                root = root.left;
            }
            else{
                root = (TreeNode)stack.pop();
                if (root.right != null){
                    stack.push(root.right);
                    root = root.right;
                } else {
                    result.add(root.val);
                }
            }
        }

        return result;
    }

    public static void main(String[] args){
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);

        List<Integer> result = postorderTraversal(treeNode);
        for (Integer i: result){
            System.out.println(i);
        }

        System.out.println("*************");

        TreeNode treeNode2 = new TreeNode(3);
        treeNode2.left = new TreeNode(1);
        treeNode2.right = new TreeNode(2);

        result = postorderTraversal(treeNode2);
        for (Integer i: result){
            System.out.println(i);
        }
    }

}
