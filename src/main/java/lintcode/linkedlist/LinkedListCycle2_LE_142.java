package lintcode.linkedlist;

import type.ListNode;

public class LinkedListCycle2_LE_142 {
    /**
     11.16.2022
     ref 东哥 post
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            //cycle detected
            if (slow == fast) {
                //ref analyst in 东哥 post
                slow = head;
                while(slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
