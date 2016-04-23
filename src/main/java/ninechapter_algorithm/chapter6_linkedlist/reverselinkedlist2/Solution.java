package ninechapter_algorithm.chapter6_linkedlist.reverselinkedlist2;

import type.ListNode;

/**
 * Author: blueaken
 * Date: 4/23/16 9:19 AM
 */
public class Solution {
    /**
     * @param ListNode head is the head of the linked list
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        // write your code
        if (head == null || m > n) {
            return null;
        }

        //find m position
        int count = 0;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while (count < m - 1) {
            prev = prev.next;
            count++;
            if (prev == null) {
                return null;
            }
        }
        ListNode prevM = prev;
        ListNode mNode = prev.next;

        //reverse m to n
        int diff = 0;
        ListNode cur = prev.next;
        while (cur != null && (diff < (n - m + 1))) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
            diff++;
        }
        ListNode postN = cur;

        //connect back
        prevM.next = prev;
        mNode.next = postN;

        return dummyHead.next;
    }
}
