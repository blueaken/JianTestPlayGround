package binarytree;

import type.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: blueaken
 * Date: 7/15/14 9:48 下午
 */
public class MaxPathNumSum {
    public static int maxPathSum(TreeNode root) {
        //find the number of nodes and then calculate n!
        List<TreeNode> treeNodes = new ArrayList<TreeNode>();
        rec(root, treeNodes);

        int sum = 0;
        for (int i=1; i<=treeNodes.size(); i++){
            sum += i;
        }
        return sum;
    }

    private static void rec(TreeNode root, List<TreeNode> nodes){
        if (root == null) return;
        nodes.add(root);
        rec(root.left, nodes);
        rec(root.right, nodes);
    }

    public static void main(String[] args){
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
//        treeNode.right.right = new TreeNode(6);

        int maxsum = maxPathSum(treeNode);
        System.out.println("Max Path Sum of the tree is: " + maxsum);
    }
}
