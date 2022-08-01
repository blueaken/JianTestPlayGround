package lintcode.binarytree;

import type.TreeNode;

/*
    - post order traverse, Time - O(N), Space - O(N), figure it out myself@
*/
public class MaximumAverageSubtree_LE_1120 {
    class Info {
        int valSum;
        int nodeNum;

        Info (int valSum, int nodeNum) {
            this.valSum = valSum;
            this.nodeNum = nodeNum;
        }
    }

    double ans = 0.0;

    public double maximumAverageSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }

    Info dfs(TreeNode node) {

        //case when node is null
        if (node == null) {
            return new Info(0, 0);
        }

        Info lInfo = dfs(node.left);
        Info rInfo = dfs(node.right);

        int valSum = node.val + lInfo.valSum + rInfo.valSum;
        int nodeSum = 1 + lInfo.nodeNum + rInfo.nodeNum;

        ans = Math.max(ans, (double) valSum / nodeSum);

        return new Info(valSum, nodeSum);
    }
}
