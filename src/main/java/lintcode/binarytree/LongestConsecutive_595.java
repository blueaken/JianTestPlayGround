package lintcode.binarytree;

import type.TreeNode;
import util.TreeNodeUtil;

public class LongestConsecutive_595 {

    int res = 0;
    int path = 0;
    /**
     * @param root: the root of binary tree
     * @return: the length of the longest consecutive sequence path
     */
    public int longestConsecutive(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }
        dfs (root, null);
        return res;
    }

    private void dfs (TreeNode node, TreeNode parent) {
        if (node == null) {
            return;
        }

        //count path value if root node OR consecutive node
        if (parent == null ||  (node.val - parent.val) == 1) {
            path++;
        }
        //record & reset path value if not consecutive node
        if (parent != null && (node.val - parent.val) != 1) {
            res = Math.max(res, path);
            path = 1;
        }
        //record path value & return if leaf node
        if (node.left == null && node.right == null) {
            res = Math.max(res, path);
            return;
        }

        dfs(node.left, node);
        dfs(node.right, node);
    }

    public static void main(String[] args) {
//        int[] input = {1,-999,3,-999,-999,2,4,-999,-999,-999,-999,-999,-999,-999,5};
//        int[] input = {2,-999,3,-999,-999,2,-999,-999,-999,-999,-999,1};
        int[] input = {1,-999,2,-999,-999,-999,4,-999,-999,-999,-999,-999,-999,-999,5};
        TreeNode root = TreeNodeUtil.buildTree(input);
        TreeNodeUtil.printTree(root);

        LongestConsecutive_595 solution = new LongestConsecutive_595();
        System.out.println(solution.longestConsecutive(root));
    }
}
