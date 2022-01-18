package lintcode.binarytree;

import type.TreeNode;
import util.TreeNodeUtil;

class ResultType {
    int sum;
    int size;
    TreeNode node;
    ResultType (int sum, int size, TreeNode node) {
        this.sum = sum;
        this.size = size;
        this.node = node;
    }
}

public class FindMaxAverageSubTree_method2_597 {
    ResultType maxAverageResult = new ResultType(0,0,null);
    /**
     * @param root: the root of binary tree
     * @return: the root of the maximum average of subtree
     */
    //Idea: 一次遍历可以同时获得size和sum信息，比自己的效率高。Ref: https://www.lintcode.com/problem/597/solution/18759
    //Note: 为避免'/'带来的精度问题，判断平均数大小使用乘法代替除法
    public TreeNode findSubtree2(TreeNode root) {
        divideConquer(root);
        return maxAverageResult.node;
    }

    private ResultType divideConquer (TreeNode node) {
        if (node == null) {
            return new ResultType(0, 0, null);
        }

        ResultType left = divideConquer(node.left);
        ResultType right = divideConquer(node.right);

        int sum = left.sum + node.val + right.sum;
        int size = left.size + 1 + right.size;

        if (maxAverageResult.node == null || sum * maxAverageResult.size > maxAverageResult.sum * size) {
            maxAverageResult.sum = sum;
            maxAverageResult.size = size;
            maxAverageResult.node = node;
        }
        return new ResultType(sum, size, node);
    }

    public static void main(String[] args) {
//        int[] input = {1,-5,11,1,2,4,-2};
//        int[] input = {-1,-2,-3,-4,-5,-6,-7,-8,-9,-10,-11,-12,-13,-14,-15,-16};
        int[] input = {-1,-2,-3,-4};
        TreeNode root = TreeNodeUtil.buildTree(input);
        TreeNodeUtil.printTree(root);

        FindMaxAverageSubTree_method2_597 solution = new FindMaxAverageSubTree_method2_597();
        System.out.println(solution.findSubtree2(root).val);
    }

}
