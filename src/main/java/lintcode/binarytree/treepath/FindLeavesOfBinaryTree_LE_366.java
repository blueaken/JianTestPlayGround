package lintcode.binarytree.treepath;

import java.util.ArrayList;
import java.util.List;

import type.TreeNode;

public class FindLeavesOfBinaryTree_LE_366 {
    /*
        11.03.2022
        ref 东哥 post - refactor the maxDepth problem with 后序 Traverse
    */
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        maxDepth(root);
        return res;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int h = 1 + Math.max(maxDepth(root.left), maxDepth(root.right));

        //add logic @ post traverse position
        if (res.size() < h) {
            res.add(new ArrayList<>());
        }

        //add some height node's value into one list
        res.get(h-1).add(root.val);

        return h;
    }
}
