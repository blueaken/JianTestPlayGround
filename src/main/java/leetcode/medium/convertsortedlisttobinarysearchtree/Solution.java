package leetcode.medium.convertsortedlisttobinarysearchtree;

import type.ListNode;
import type.TreeNode;

/**
 * Author: blueaken
 * Date: 9/30/15 9:30 AM
 */
public class Solution {
    public static TreeNode sortedListToBST(ListNode head) {
        if (head==null) return null;
        TreeNode bst = rec(head, null);
        return bst;
    }

    static TreeNode rec(ListNode start, ListNode end){
        //close condition
        if (start == end) return null;


        //find mid with slow/fast pointer
        ListNode slow = start;
        ListNode fast = start;
        while(fast!=end && fast.next!=end){
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode node = new TreeNode(slow.val);
        node.left = rec(start, slow);
        node.right = rec(slow.next, end);
        return node;
    }

//    private static ListNode list;
//    private static TreeNode sortedListToBST(int start, int end) {
//        if (start > end) return null;
//        int mid = (start + end) / 2;
//        TreeNode leftChild = sortedListToBST(start, mid-1);
//        TreeNode parent = new TreeNode(list.val);
//        parent.left = leftChild;
//        list = list.next;
//        parent.right = sortedListToBST(mid+1, end);
//        return parent;
//    }
//    public static TreeNode sortedListToBST(ListNode head) {
//        int n = 0;
//        ListNode p = head;
//        while (p != null) {
//            p = p.next;
//            n++;
//        }
//        list = head;
//        return sortedListToBST(0, n - 1);
//    }

    public static void main(String[] args){

        ListNode ln = new ListNode(1);
        ln.next = new ListNode(2);
        ln.next.next = new ListNode(3);
        ln.next.next.next = new ListNode(4);
//        ln.next.next.next.next = new ListNode(5);
//        ln.next.next.next.next.next = new ListNode(6);
//        ln.next.next.next.next.next.next = new ListNode(7);

        TreeNode bst = sortedListToBST(ln);
        System.out.println(bst.val);
    }

}
