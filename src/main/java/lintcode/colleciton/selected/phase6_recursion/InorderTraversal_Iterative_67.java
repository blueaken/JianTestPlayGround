package lintcode.colleciton.selected.phase6_recursion;

import type.TreeNode;
import util.TreeNodeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal_Iterative_67 {
    /**
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        //Iterative solution with Stack
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                res.add(node.val);
                node = node.right;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = {1,2,3};
        TreeNode root = TreeNodeUtil.buildTree(input);

//        TreeNodeUtil.printTree(root);

        System.out.println(inorderTraversal(root).toString());
    }

}
