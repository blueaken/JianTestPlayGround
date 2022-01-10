package lintcode.binarytree;

import type.DoublyListNode;
import type.TreeNode;

public class BstToDoublyList_Rec_378 {
    /**
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    //Key Idea: Inorder with recursive, using dummy node as virtual linkedlist head

    public DoublyListNode dummy = new DoublyListNode(-1);
    public DoublyListNode cur = dummy;

    public DoublyListNode bstToDoublyList(TreeNode root) {
        // write your code here
        if (root == null) return null;

        rec(root);

        return dummy.next;
    }

    private  void rec(TreeNode node) {
        if (node == null) return;

        if (node.left != null) {
            rec(node.left);
        }

        DoublyListNode newNode = new DoublyListNode(node.val);
        this.cur.next = newNode;
        newNode.prev = this.cur;
        this.cur = this.cur.next;

        if (node.right != null) {
            rec(node.right);
        }

        return;
    }
}
