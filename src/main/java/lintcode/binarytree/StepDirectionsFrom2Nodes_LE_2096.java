package lintcode.binarytree;

import type.TreeNode;

public class StepDirectionsFrom2Nodes_LE_2096 {
    /**
     1.12.24
     ref 东哥post, 3 steps:
     1. dfs find start path and dest path
     2. remove the prefix, since dfs start from root not LCA
     3. turn start path into all "U"s and combine with dest path
     */
    int startValue, destValue;
    String startPath, destPath;
    public String getDirections(TreeNode root, int startValue, int destValue) {
        this.startValue = startValue;
        this.destValue = destValue;

        StringBuilder path = new StringBuilder();
        traverse(root, path);

        // remove common prefix
        int pos = 0, m = startPath.length(), n = destPath.length();
        while (pos < m && pos < n && startPath.charAt(pos) == destPath.charAt(pos)) {
            pos++;
        }
        startPath = startPath.substring(pos);
        destPath = destPath.substring(pos);

        // update start path and make the result
        startPath = "U".repeat(startPath.length());
        return startPath + destPath;
    }

    void traverse(TreeNode node, StringBuilder path) {
        if (node == null) {
            return;
        }

        if (node.val == startValue) {
            startPath = path.toString();
        } else if (node.val == destValue) {
            destPath = path.toString();
        }

        path.append('L');
        traverse(node.left, path);
        path.deleteCharAt(path.length()-1);

        path.append('R');
        traverse(node.right, path);
        path.deleteCharAt(path.length()-1);
    }

    public static void main(String[] args) {
        StepDirectionsFrom2Nodes_LE_2096 solution = new StepDirectionsFrom2Nodes_LE_2096();
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(1);
        node.left.left = new TreeNode(3);
        node.right = new TreeNode(2);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(4);

        System.out.println(solution.getDirections(node, 3, 6));
    }
}
