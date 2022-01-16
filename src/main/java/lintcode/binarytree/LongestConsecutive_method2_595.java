package lintcode.binarytree;

import type.TreeNode;
import util.TreeNodeUtil;

public class LongestConsecutive_method2_595 {

    int res = 0;
    /**
     * @param root: the root of binary tree
     * @return: the length of the longest consecutive sequence path
     */
    //Ref: https://www.lintcode.com/problem/595/solution/17658, 效率比自己的初版要好
    public int longestConsecutive(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }
        dfs (root, 1);
        return res;
    }

    private void dfs (TreeNode node, int path) {
        if (node == null) {
            return;
        }

        res = Math.max(res, path);

        if (node.left != null) {
            if ((node.left.val - node.val) == 1) {
                dfs(node.left, path + 1);
            } else {
                dfs(node.left, 1);
            }
        }
        if (node.right != null) {
            if ((node.right.val - node.val) == 1) {
                dfs(node.right, path + 1);
            } else {
                dfs(node.right, 1);
            }
        }

    }

    public static void main(String[] args) {
//        int[] input = {1,-999,3,-999,-999,2,4,-999,-999,-999,-999,-999,-999,-999,5};
//        int[] input = {2,-999,3,-999,-999,2,-999,-999,-999,-999,-999,1};
        int[] input = {1,-999,2,-999,-999,-999,4,-999,-999,-999,-999,-999,-999,-999,5};
        TreeNode root = TreeNodeUtil.buildTree(input);
        TreeNodeUtil.printTree(root);

        LongestConsecutive_method2_595 solution = new LongestConsecutive_method2_595();
        System.out.println(solution.longestConsecutive(root));
    }
}
