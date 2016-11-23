package ninechapter_algorithm.chapter6_linkedlist.optional.removeduplicatesfromunsortedlist.second;

import type.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Author: blueaken
 * Date: 7/17/16 18:53
 */
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: head node
     */
    public ListNode removeDuplicates(ListNode head) {
        // Write your code here
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        Set<Integer> visited = new HashSet<>();

        while (cur != null) {
            if (visited.contains(cur.val)) {
                pre.next = cur.next;
                cur = pre.next;
            } else {
                visited.add(cur.val);
                pre = pre.next;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
