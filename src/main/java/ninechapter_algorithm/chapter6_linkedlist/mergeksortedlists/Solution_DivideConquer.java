package ninechapter_algorithm.chapter6_linkedlist.mergeksortedlists;

import type.ListNode;

import java.util.List;

/**
 * Author: blueaken
 * Date: 4/25/16 12:22 PM
 */
public class Solution_DivideConquer {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        // write your code here
        if (lists == null || lists.size() == 0) {
            return null;
        }

        int size = lists.size();
        int end = size - 1;
        while (end > 0) {
            int start = 0;
            while (start < end) {
                lists.set(start, merge2Lists(lists.get(start++), lists.get(end--)));
            }
        }
        return lists.get(0);
    }

    private ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }
        return dummyHead.next;
    }
}
