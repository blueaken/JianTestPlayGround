package ninechapter_algorithm.chapter6_linkedlist.optional.convertbinarysearchtreetodoublylinkedlist;

import type.DoublyListNode;
import type.TreeNode;

/**
 * Author: blueaken
 * Date: 5/18/16 09:47
 */
class ResultType {
    DoublyListNode first;
    DoublyListNode last;
    public ResultType(DoublyListNode first, DoublyListNode last) {
        this.first = first;
        this.last = last;
    }
}

public class Solution {
    /**
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    public DoublyListNode bstToDoublyList(TreeNode root) {
        // Write your code here
        if (root == null) {
            return null;
        }

        ResultType result = rec(root);
        return result.first;
    }

    private ResultType rec(TreeNode node) {
        if (node == null) {
            return null;
        }
        ResultType result = new ResultType(null, null);

        //the idea is to find and maintain relationship of the inorder predecessor and successor
        ResultType left = rec(node.left);
        DoublyListNode cur = new DoublyListNode(node.val);
        ResultType right = rec(node.right);

        if (left == null) {
            result.first = cur;
        } else {
            result.first = left.first;
            left.last.next = cur;
            cur.prev = left.last;
        }
        if (right == null) {
            result.last = cur;
        } else {
            result.last = right.last;
            right.first.prev = cur;
            cur.next = right.first;
        }

        return result;
    }
}
