package ninechapter_algorithm.chapter6_linkedlist.optional.removeduplicates;

import type.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Author: blueaken
 * Date: 5/11/16 08:37
 */
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: head node
     */
    public ListNode removeDuplicates(ListNode head) {
        // Write your code here
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        Set<Integer> visited = new HashSet<>();

        while (cur != null) {
            if (visited.contains(cur.val)) {
                prev.next = cur.next;
                cur = prev.next;
                continue;
            } else {
                visited.add(cur.val);
                prev = prev.next;
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}
