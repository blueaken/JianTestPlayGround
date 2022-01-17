package lintcode.binarytree;

import type.TreeNode;
import util.TreeNodeUtil;

public class FindMinSubtree_596 {
    /**
     * @param root: the root of binary tree
     * @return: the root of the minimum subtree
     */
    //Idea: ref - https://www.lintcode.com/problem/596/solution/40195

    TreeNode minNode;
    int minSum = Integer.MAX_VALUE;
    public TreeNode findMinSubtree(TreeNode root) {
        // write your code here
        if (root == null) {
            return null;
        }
        divideConquer(root);
        return minNode;
    }

    //return current node sum
    private int divideConquer(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 使用分治法计算出当前树节点的和
        // 树的和 = 根节点的值 + 左子树和 + 右子树的和
        int leftSum = divideConquer(node.left);
        int rightSum = divideConquer(node.right);
        int sum = leftSum + node.val + rightSum;

        if (sum < minSum) {
            minSum = sum;
            minNode = node;
        }

        return sum;
    }

    public static void main(String[] args) {
//        int[] input = {1};
//        int[] input = {1,-5,2,1,2,-4,-5};
        int[] input = {1,5,2,1,2,-4,-5};
        TreeNode root = TreeNodeUtil.buildTree(input);
        TreeNodeUtil.printTree(root);

        FindMinSubtree_596 solution = new FindMinSubtree_596();
        System.out.println(solution.findMinSubtree(root).val);
    }
}
