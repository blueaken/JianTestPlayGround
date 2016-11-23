package ninechapter_algorithm.chapter6_linkedlist.optional.swaptwonodesinlinkedlist;

import type.ListNode;

/**
 * Author: blueaken
 * Date: 5/17/16 09:39
 */
public class Solution {
    /**
     * @param head a ListNode
     * @oaram v1 an integer
     * @param v2 an integer
     * @return a new head of singly-linked list
     */
    public ListNode swapNodes(ListNode head, int v1, int v2) {
        // Write your code here
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preV1 = dummy;
        ListNode v1node = head;
        while (v1node != null && v1node.val != v1) {
            preV1 = preV1.next;
            v1node = v1node.next;
        }
        if (v1node == null) {
            return head;
        }

        ListNode preV2 = dummy;
        ListNode v2node = head;
        while (v2node != null && v2node.val != v2) {
            preV2 = preV2.next;
            v2node = v2node.next;
        }
        if (v2node == null) {
            return head;
        }

        ListNode temp1 = v1node.next;
        ListNode temp2 = v2node.next;
        //other than the general case need to deal with when v1node and v2node are neighbours
        if (temp1 == v2node) {
            preV1.next = v2node;
            v2node.next = v1node;
            v1node.next = temp2;
        } else if (temp2 == v1node) {
            preV2.next = v1node;
            v1node.next = v2node;
            v2node.next = temp1;
        } else {
            preV1.next = v2node;
            v2node.next = temp1;
            preV2.next = v1node;
            v1node.next = temp2;
        }

        return dummy.next;
    }
}
