package level2;

import type.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: blueaken
 * Date: 7/10/14 9:13 下午
 */
public class PostorderTravel_R {
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rec(root, result);

        return result;
    }

    private static void rec(TreeNode root, List<Integer> result){
        if (root == null) return;

        rec(root.left, result);
        rec(root.right, result);
        result.add(root.val);
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
