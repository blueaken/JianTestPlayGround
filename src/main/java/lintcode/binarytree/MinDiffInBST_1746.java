package lintcode.binarytree;

import type.TreeNode;
import util.TreeNodeUtil;

public class MinDiffInBST_1746 {
    int minDiff = Integer.MAX_VALUE;
    TreeNode pre = null;
    /**
     * @param root:  a Binary Search Tree (BST) with the root node
     * @return: the minimum difference
     */
    //Idea: 二叉搜索树右子树总是比左子树大，最小差产生在相邻2个节点的差中产生，使用中序遍历
    //ref - https://www.lintcode.com/problem/1746/solution/30454
    public int minDiffInBST(TreeNode root) {
        // Write your code here.
        if (root == null) {
            return 0;
        }
        minDiffInBST(root.left);
        if (pre != null) {
            minDiff = Math.min(minDiff, root.val - pre.val);
        }
        pre = root;
        minDiffInBST(root.right);

        return minDiff;
    }

    public static void main(String[] args) {
//        int[] input = {4,2,6,1,3};
        int[] input = {1,-999,2,-999,-999,-999,3,-999,-999,-999,-999,-999,-999,-999,4};
        TreeNode root = TreeNodeUtil.buildTree(input);
        TreeNodeUtil.printTree(root);

        MinDiffInBST_1746 solution = new MinDiffInBST_1746();
        System.out.println(solution.minDiffInBST(root));
    }

}
