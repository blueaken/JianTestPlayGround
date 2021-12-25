package lintcode.colleciton.selected.phase6_recursion;

import java.util.ArrayList;
import java.util.List;
import type.TreeNode;

public class PostorderTraversal_Recursive_68 {
    /**
     * @param root: A Tree
     * @return: Postorder in ArrayList which contains node values.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root.left != null) {
            helper(root.left, res);
        }
        if (root.right != null) {
            helper(root.right, res);
        }
        res.add(root.val);
        return;
    }
}
