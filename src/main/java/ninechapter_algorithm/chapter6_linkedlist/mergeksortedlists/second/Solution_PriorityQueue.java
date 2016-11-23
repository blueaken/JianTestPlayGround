package ninechapter_algorithm.chapter6_linkedlist.mergeksortedlists.second;

import type.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Author: blueaken
 * Date: 5/14/16 10:14
 */
class ListNodeComparator implements Comparator<ListNode> {
    @Override
    public int compare(ListNode a, ListNode b) {
        return a.val - b.val;
    }
}

public class Solution_PriorityQueue {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        // write your code here
        if (lists == null || lists.size() == 0) {
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.size(), new ListNodeComparator());
        ListNode dummyHead = new ListNode(0);
        ListNode pointer = dummyHead;
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        while (pq.size() > 0) {
            ListNode cur = pq.poll();
            pointer.next = cur;
            pointer = pointer.next;
            if (cur.next != null) {
                pq.add(cur.next);
            }
        }
        return dummyHead.next;
    }
}