package level2;

import type.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianshen
 */
public class InorderTravel_R {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        inorder(root, result);

        return result;
    }

    private static void inorder(TreeNode root, List<Integer> result){
        if (root == null) return;
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }

    public static void main(String[] args){
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);

        List<Integer> result = inorderTraversal(treeNode);
        for (Integer i: result){
            System.out.println(i);
        }
    }
}
