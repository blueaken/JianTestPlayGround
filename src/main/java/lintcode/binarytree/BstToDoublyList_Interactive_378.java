package lintcode.binarytree;

import type.DoublyListNode;
import type.TreeNode;

import java.util.Stack;

public class BstToDoublyList_Interactive_378 {
    /**
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    //Key Idea: Inorder with interactive access

    public DoublyListNode bstToDoublyList(TreeNode root) {
        // write your code here
        if (root == null) return null;

        DoublyListNode dummy = new DoublyListNode(-1);
        DoublyListNode cur = dummy;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while (stack.size() > 0 || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            if (stack.size() > 0) {
                node = stack.pop();
                DoublyListNode newNode = new DoublyListNode(node.val);
                cur.next = newNode;
                newNode.prev = cur;
                cur = cur.next;

                node = node.right;
            }
        }

        return dummy.next;
    }


}
