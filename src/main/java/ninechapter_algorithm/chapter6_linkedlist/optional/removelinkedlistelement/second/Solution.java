package ninechapter_algorithm.chapter6_linkedlist.optional.removelinkedlistelement.second;

import type.ListNode;

/**
 * Author: blueaken
 * Date: 7/17/16 18:35
 */
public class Solution {
    /**
     * @param head a ListNode
     * @param val an integer
     * @return a ListNode
     */
    public ListNode removeElements(ListNode head, int val) {
        // Write your code here
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;

        while (cur!= null) {
            if (val == cur.val) {
                while (cur != null && val == cur.val) {
                    ListNode temp = cur.next;
                    pre.next = temp;
                    cur = pre.next;
                }
                continue;
            } else {
                pre = pre.next;
                cur = cur.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(7);

        solution.removeElements(head, 7);
    }
}
