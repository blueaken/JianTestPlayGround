package lintcode.binarysearchtree;

import type.TreeNode;
import util.TreeNodeUtil;

public class LargestBSTSubtree_LE_333 {
    /**
     12.16.23
     ref LE 98, similar way to handle BST
     */
    int res = 0;
    public int largestBSTSubtree(TreeNode root) {
        findLargestBST(root);
        return res;
    }

    int[] findLargestBST(TreeNode root) {
        if (root == null) {
            // empty tree is also valid BST, note the init val if min value is a max value, and vice versa
            return new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }

        int[] left = findLargestBST(root.left);
        int[] right = findLargestBST(root.right);

        if (left == null || right == null) {
            // left child or right child is not BST then current tree also not BST
            return null;
        }

        int leftMin = left[0], leftMax = left[1], leftCount = left[2];
        int rightMin = right[0], rightMax = right[1], rightCount = right[2];

        if (leftMax < root.val && root.val < rightMin) {
            int rootMin = Math.min(leftMin, root.val);
            int rootMax = Math.max(rightMax, root.val);
            int rootCount = leftCount + rightCount + 1;
            res = Math.max(res, rootCount);

            return new int[] {rootMin, rootMax, rootCount};
        }

        return null;
    }

    public static void main(String[] args) {
        LargestBSTSubtree_LE_333 solution = new LargestBSTSubtree_LE_333();
        int[] input = {10,5,15,1,8,-999,7};
        TreeNode root = TreeNodeUtil.buildTree(input);
        TreeNodeUtil.printTree(root);

        System.out.println(solution.largestBSTSubtree(root));
    }
}
