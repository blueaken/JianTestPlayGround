package ninechapter_algorithm.chapter6_linkedlist.optional.deletenodeinthemiddleofsinglylinkedlist.second;

import type.ListNode;

/**
 * Author: blueaken
 * Date: 7/18/16 17:38
 */
public class Solution {
    /**
     * @param node: the node in the list should be deleted
     * @return: nothing
     */
    public void deleteNode(ListNode node) {
        // write your code here
        if (node == null) {
            return;
        }

        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
        return;
    }
}
