package ninechapter_algorithm.chapter6_linkedlist.linkedlistcycle2.second;

import type.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Author: blueaken
 * Date: 7/24/16 11:50
 */
public class Solution_WithExtraSpace {
    /**
     * @param head: The first node of linked list.
     * @return: The node where the cycle begins.
     *           if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {
        // write your code here
        if (head == null) {
            return head;
        }

        Set<ListNode> visited = new HashSet<>();
        ListNode node = head;
        while (node != null) {
            if (visited.contains(node)) {
                return node;
            }
            visited.add(node);
            node = node.next;
        }
        return null;
    }
}
