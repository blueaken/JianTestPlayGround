package lintcode.colleciton.selected.phase6_recursion;

import type.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal_Interactive_68 {
    /**
     * @param root: A Tree
     * @return: Postorder in ArrayList which contains node values.
     */
    /**
     * Key Idea: https://blog.csdn.net/xinguimeng/article/details/88785320
     * 根据单栈法来实现二叉树的后序遍历
     * 它这里用一个变量previous来保存当前最后访问的节点，它必须在访问后设置
     * 如何来判断一个节点node的左右子树都被访问呢?
     * 使用: previous != null && (node.left == previous || node.right == previous)
     *
     * 它的思路就是:
     * 如果一个节点的左右子树均被访问过或者是叶子节点，那么就访问它
     * 否则把右子树和左子树依次压入到栈中
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        // write your code here

        //Iterative solution with Stack
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        TreeNode previous = null;
        TreeNode node = null;
        boolean isLeafNode = false;
        boolean isVisitedNode = false;

        while (!stack.isEmpty()) {
            node = stack.peek();
            isLeafNode = node.left == null && node.right == null;
            isVisitedNode = previous != null && (node.left == previous || node.right == previous);

            if (isLeafNode || isVisitedNode) {
                res.add(node.val);
                stack.pop();
                previous = node;
            } else {
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(postorderTraversal(root).toString());
    }

}
