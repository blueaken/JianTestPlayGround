package lintcode.binarytree;

import type.TreeNode;
import util.TreeNodeUtil;

import java.util.HashSet;
import java.util.Set;

public class FindMaxAverageSubTree_597 {
    TreeNode maxAverageNode;
    double maxAverage = Double.MAX_VALUE * -1;
    /**
     * @param root: the root of binary tree
     * @return: the root of the maximum average of subtree
     */
    //Idea: similar to 596, divide and conquer left & right subTrees
    public TreeNode findSubtree2(TreeNode root) {
        // write your code here
        if (root == null) {
            return null;
        }
        divideConquer(root);
        return maxAverageNode;
    }

    //return average
    private double divideConquer(TreeNode node) {
        if (node == null) {
            return 0;
        }
        double leftAverage = divideConquer(node.left);
        double rightAverage = divideConquer(node.right);

        int leftSize = countNodes(node.left);
        int rightSize = countNodes(node.right);
        double average = (leftAverage * leftSize + node.val + rightAverage * rightSize) / (leftSize + 1 + rightSize);

        if (maxAverage < average) {
            maxAverageNode = node;
            maxAverage = average;
        }
        return average;
    }

    private int countNodes (TreeNode root) {
        Set<TreeNode> set = new HashSet<>();
        dfs (root, set);
        return set.size();
    }

    private void dfs (TreeNode node, Set<TreeNode> set) {
        if (node == null) {
            return;
        }
        set.add(node);
        dfs(node.left, set);
        dfs(node.right, set);
    }

    public static void main(String[] args) {
//        int[] input = {1,-5,11,1,2,4,-2};
        int[] input = {-1,-2,-3,-4,-5,-6,-7,-8,-9,-10,-11,-12,-13,-14,-15,-16};
//        int[] input = {-1,-2,-3,-4,-5,-6,-7,-8};
        TreeNode root = TreeNodeUtil.buildTree(input);
        TreeNodeUtil.printTree(root);

        FindMaxAverageSubTree_597 solution = new FindMaxAverageSubTree_597();
        System.out.println(solution.findSubtree2(root).val);
    }
}
