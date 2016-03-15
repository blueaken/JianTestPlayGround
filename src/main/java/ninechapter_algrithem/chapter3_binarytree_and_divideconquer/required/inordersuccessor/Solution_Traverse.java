package ninechapter_algrithem.chapter3_binarytree_and_divideconquer.required.inordersuccessor;

import type.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: blueaken
 * Date: 2/28/16 8:11 PM
 */
public class Solution_Traverse {
    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        List<TreeNode> list = new ArrayList<>();
        rec (root, list);

        if (list.size() > 0) {
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i) == p) {
                    return list.get(i+1);
                }
            }
        }

        return null;
    }

    private static void rec(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }

        rec (node.left, list);
        list.add(node);
        rec (node.right, list);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);

        TreeNode target = new TreeNode(3);
        treeNode.right = target;
        treeNode.right.right = new TreeNode(6);

        System.out.println(inorderSuccessor(treeNode, target).val);
    }
}
