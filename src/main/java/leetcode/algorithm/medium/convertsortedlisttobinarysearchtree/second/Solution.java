package leetcode.algorithm.medium.convertsortedlisttobinarysearchtree.second;

import type.ListNode;
import type.TreeNode;

/**
 * Author: blueaken
 * Date: 2/12/16 9:44 AM
 */
public class Solution {
    private static ListNode list;

    public static TreeNode sortedListToBST(ListNode head) {
        list = head;

        //find the list length
        int n = 0;
        while(head!=null){
            head = head.next;
            n++;
        }

        return rec(0, n-1);
    }

    private static TreeNode rec(int start, int end){
        //pre order traversal
        if (start>end) return null;

        int mid = (start+end)/2;
        TreeNode left = rec(start, mid-1);
        TreeNode node = new TreeNode(list.val);
        list = list.next;
        node.left = left;
        node.right = rec(mid+1, end);

        return node;
    }

    public static void main(String[] args){
        ListNode ln = new ListNode(1);
        ln.next = new ListNode(2);
        ln.next.next = new ListNode(3);
        ln.next.next.next = new ListNode(4);

        TreeNode bst = sortedListToBST(ln);
        realworld.emc.printbinarysearchtree.Solution.printBinaryTree(bst);
    }
}
