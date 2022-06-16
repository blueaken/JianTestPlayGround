package lintcode.binarytree;

import java.util.HashSet;
import java.util.Set;
import type.TreeNode;

public class TwoSum4_LE_653 {
    /*
        - ref https://leetcode.com/problems/two-sum-iv-input-is-a-bst/discuss/106059/JavaC%2B%2B-Three-simple-methods-choose-one-you-like
        - use a hashtable to save the values of the nodes in the BST. Each time when we insert the value of a new node into the hashtable, we check if the hashtable contains k - node.val.
        - Time Complexity: O(n), Space Complexity: O(n).
    */
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return dfs(root, k, set);
    }

    private boolean dfs(TreeNode root, int k, Set<Integer> set) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }

        set.add(root.val);
        return dfs(root.left, k, set) || dfs(root.right, k, set);
    }
}
