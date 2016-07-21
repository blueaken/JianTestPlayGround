package ninechapter_algorithm.chapter6_linkedlist.optional.swaptwonodesinlinkedlist.second;

import type.ListNode;

/**
 * Author: blueaken
 * Date: 7/18/16 17:29
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
        ListNode v1Node = head;

        ListNode preV2 = dummy;
        ListNode v2Node = head;

        while (v1Node != null && v1Node.val != v1) {
            preV1 = preV1.next;
            v1Node = v1Node.next;
        }
        while (v2Node != null && v2Node.val != v2) {
            preV2 = preV2.next;
            v2Node = v2Node.next;
        }
        if (v1Node == null || v2Node == null) {
            return head;
        }

        ListNode v1Next = v1Node.next;
        ListNode v2Next = v2Node.next;
        if (v1Node.next == v2Node) {
            preV1.next = v2Node;
            v2Node.next = v1Node;
            v1Node.next = v2Next;
        } else if (v2Node.next == v1Node) {
            preV2.next = v1Node;
            v1Node.next = v2Node;
            v2Node.next = v1Next;
        } else {
            preV1.next = v2Node;
            v2Node.next = v1Next;
            preV2.next = v1Node;
            v1Node.next = v2Next;
        }
        return dummy.next;
    }
}
