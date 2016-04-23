package ninechapter_algorithm.chapter6_linkedlist.deleteduplicates2;

import type.ListNode;

/**
 * Author: blueaken
 * Date: 4/22/16 9:30 AM
 */
public class Solution {
    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of the linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if (head == null) {
            return head;
        }

        //dummy head
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode preDelete = dummyHead;
        ListNode pointer = head;

        boolean searchMode = false;
        while (pointer.next != null) {
            if (pointer.val == pointer.next.val) {
                searchMode = true;
                pointer = pointer.next;
            } else {
                if (searchMode) {
                    pointer = pointer.next;
                    preDelete.next = pointer;
                    searchMode = false;
                } else {
                    pointer = pointer.next;
                    preDelete = preDelete.next;
                }
            }
        }

        //in case of duplicates at the end
        if (searchMode) {
            preDelete.next = null;
        }

        return dummyHead.next;
    }
}
