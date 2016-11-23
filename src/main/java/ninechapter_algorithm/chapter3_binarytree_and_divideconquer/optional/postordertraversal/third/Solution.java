package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.optional.postordertraversal.third;

import type.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Author: blueaken
 * Date: 6/26/16 20:00
 */
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode previous = null;
        while(stack.size() > 0) {
            TreeNode node = stack.peek();
            //如果当前结点没有孩子结点或者孩子节点都已被访问过
            //正常情况下应该previous ＝ node.right，但在没有右子树的情况下左子树被访问过后也能开始处理当中Node
            if ((node.left == null && node.right == null)
                    || previous != null && (previous == node.right || previous == node.left)) {
                result.add(node.val);
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

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        //expect 231
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        //expect 5 13 17 15 10
//        TreeNode node = new TreeNode(10);
//        node.left = new TreeNode(5);
//        node.right = new TreeNode(15);
//        node.right.left = new TreeNode(13);
//        node.right.right = new TreeNode(17);

        System.out.println(solution.postorderTraversal(node));
    }
}
