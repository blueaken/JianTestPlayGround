package ninechapter_algorithm.chapter6_linkedlist.reverselinkedlist2.third;

import type.ListNode;

/**
 * Author: blueaken
 * Date: 7/23/16 10:42
 */
public class Solution {
    /**
     * @param ListNode head is the head of the linked list
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        // write your code
        if (head == null) {
            return null;
        }

        //find m
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preM = dummy;
        ListNode mNode = preM.next;
        for (int i = 1; i < m; i++) {
            if (mNode == null) {
                return null;
            }
            preM = preM.next;
            mNode = mNode.next;
        }

        //reverse m to n
        ListNode prev = null;
        ListNode node = mNode;
        for (int i = 0; i <= n - m; i++) {
            if (node == null) {
                return null;
            }
            ListNode temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
        }

        //combine
        preM.next = prev;
        mNode.next = node;
        return dummy.next;
    }
}
