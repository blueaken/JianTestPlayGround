package binarytree;

import type.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: blueaken
 * Date: 7/10/14 8:51 下午
 */
public class PreorderTravel_R {
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rec(root, result);
        return result;
    }

    private static void rec(TreeNode root, List<Integer> result){
        if (root == null) return;
        result.add(root.val);
        rec(root.left, result);
        rec(root.right, result);
    }

    public static void main(String[] args){
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);

        List<Integer> result = preorderTraversal(treeNode);
        for (Integer i: result){
            System.out.println(i);
        }
    }
}
