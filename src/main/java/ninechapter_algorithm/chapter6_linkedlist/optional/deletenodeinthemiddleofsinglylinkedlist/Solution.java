package ninechapter_algorithm.chapter6_linkedlist.optional.deletenodeinthemiddleofsinglylinkedlist;

import type.ListNode;

/**
 * Author: blueaken
 * Date: 5/16/16 10:55
 */
public class Solution {
    /**
     * @param node: the node in the list should be deleted
     * @return: nothing
     */
    public void deleteNode(ListNode node) {
        // write your code here
        if (node == null || node.next == null) {
            return;
        }

        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
        return;
    }
}
