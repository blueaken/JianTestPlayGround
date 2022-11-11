package lintcode.binarysearchtree;

import type.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTrees2_LE_95 {
    /**
     ref 东哥 post
     - similar to 96
     - solve with topdown dp
     */
    public List<TreeNode> generateTrees(int n) {
        return build(1, n);
    }

    private List<TreeNode> build(int lo, int hi) {
        List<TreeNode> res = new ArrayList<>();

        //base case - note empty node still need add to the result list
        if (lo > hi) {
            res.add(null);
            return res;
        }

        for (int i = lo; i <= hi; i++) {
            List<TreeNode> left = build(lo, i-1);
            List<TreeNode> right = build(i+1, hi);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
