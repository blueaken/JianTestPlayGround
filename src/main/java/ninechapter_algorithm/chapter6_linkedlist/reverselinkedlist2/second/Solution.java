package ninechapter_algorithm.chapter6_linkedlist.reverselinkedlist2.second;

import type.ListNode;

/**
 * Author: blueaken
 * Date: 5/10/16 22:10
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
            return head;
        }

        //find m node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for (int i = 0; i < m - 1; i++) {
            if (prev != null) {
                prev = prev.next;
            } else {
                return null;
            }
        }
        ListNode prevM = prev;
        ListNode mNode = prev.next;

        //reverse m to n
        ListNode cur = mNode;
        for (int i = 0; i < n - m + 1; i++) {
            if (cur != null) {
                ListNode temp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = temp;
            } else {
                return null;
            }
        }
        ListNode postN = cur;

        //link together
        prevM.next = prev;
        mNode.next = postN;

        return dummy.next;
    }

}
