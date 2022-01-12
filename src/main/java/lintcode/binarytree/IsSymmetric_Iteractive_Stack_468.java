package lintcode.binarytree;

import type.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IsSymmetric_Iteractive_Stack_468 {
    /**
     * @param root: the root of binary tree.
     * @return: true if it is a mirror of itself, or false.
     */
    //Idea:
    //1. 这里的迭代法可不是前中后序的迭代写法，因为本题的本质是判断两个树是否是相互翻转的，其实已经不是所谓二叉树遍历的前中后序的关系了,这里我们可以使用队列来比较两个树（根节点的左右子树）是否相互翻转，（注意这不是层序遍历）
    //2. ref: https://programmercarl.com/0101.%E5%AF%B9%E7%A7%B0%E4%BA%8C%E5%8F%89%E6%A0%91.html#%E8%BF%AD%E4%BB%A3%E6%B3%95
    public boolean isSymmetric(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);

        while (stack.size() > 0) {
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();
            // 左节点为空并且右节点为空，此时说明是对称的
            if (left == null && right == null) {
                continue;
            }
            // 左右一个节点不为空，或者都不为空但数值不相同，返回false
            if (left == null || right == null || left.val != right.val) {
                return false;
            }
            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
        }

        return true;
    }

}
