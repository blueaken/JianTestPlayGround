package lintcode.binarytree.level;

import type.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindLargestValueInEachTreeRow_LE_515 {
    /*
        typical level order traverse
        =======================
        ref 东哥post，try DFS recursive for level traverse
        =======================
    */
    List<Integer> res = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return res;
        }

        traverse(root, 0);
        return res;
    }

    private void traverse(TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        //add logic @ preorder position
        if (res.size() == depth) {
            //1st visit to current depth level
            res.add(root.val);
        } else {
            int temp = Math.max(res.get(depth), root.val);
            res.set(depth, temp);
        }

        traverse(root.left, depth + 1);
        traverse(root.right, depth + 1);
    }
}
