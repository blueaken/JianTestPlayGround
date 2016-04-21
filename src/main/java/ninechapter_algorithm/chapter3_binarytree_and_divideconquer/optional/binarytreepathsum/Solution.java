package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.optional.binarytreepathsum;

import type.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: blueaken
 * Date: 4/21/16 9:29 AM
 */
public class Solution {
    /**
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        rec(root, target - root.val, result, list);
        return result;
    }

    private void rec(TreeNode node, int target, List<List<Integer>> result, List<Integer> list) {
        if (node.left == null && node.right == null) {
            if (target == 0) {
                result.add(new ArrayList<>(list));
            }
            return;
        }

        if (node.left != null) {
            list.add(node.left.val);
            rec(node.left, target - node.left.val, result, list);
            list.remove(list.size() - 1);
        }

        if (node.right != null) {
            list.add(node.right.val);
            rec(node.right, target - node.right.val, result, list);
            list.remove(list.size() - 1);
        }

        return;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(4);
        treeNode.left.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(3);

        int target = 5;

        Solution solution = new Solution();
        System.out.println(solution.binaryTreePathSum(treeNode, target));
    }
}
