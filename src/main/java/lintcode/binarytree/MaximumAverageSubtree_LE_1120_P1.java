package lintcode.binarytree;

import type.TreeNode;

public class MaximumAverageSubtree_LE_1120_P1 {
    /*
        P1
        - refer previous notes
        - post order traverse, similar to divide & conquer
    */

    class Info {
        int nodeSum;
        double valueSum;

        Info(int nodeSum, double valueSum) {
            this.nodeSum = nodeSum;
            this.valueSum = valueSum;
        }
    }

    double ans;
    public double maximumAverageSubtree(TreeNode root) {
        ans = 0.0;
        dfs(root);
        return ans;
    }

    private Info dfs(TreeNode node) {
        if (node == null) {
            return new Info(0, 0);
        }

        Info lInfo = dfs(node.left);
        Info rInfo = dfs(node.right);
        int nodeSum = lInfo.nodeSum + rInfo.nodeSum + 1;
        double valueSum = lInfo.valueSum + rInfo.valueSum + node.val;

        ans = Math.max(ans, valueSum / nodeSum);
        return new Info(nodeSum, valueSum);
    }
}
