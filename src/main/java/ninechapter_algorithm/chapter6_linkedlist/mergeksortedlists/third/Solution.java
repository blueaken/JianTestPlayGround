package ninechapter_algorithm.chapter6_linkedlist.mergeksortedlists.third;

import type.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Author: blueaken
 * Date: 7/22/16 11:49
 */
class ListNodeComparator implements Comparator<ListNode> {
    @Override
    public int compare(ListNode a, ListNode b) {
        return a.val - b.val;
    }
}
public class Solution {
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
        for (int i = 0; i < lists.size(); i++) {
            ListNode ln = lists.get(i);
            if (ln != null) {
                pq.offer(lists.get(i));
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while (pq.size() > 0) {
            ListNode ln = pq.poll();
            node.next = new ListNode(ln.val);
            node = node.next;

            if (ln.next != null) {
                pq.offer(ln.next);
            }
        }
        return dummy.next;
    }
}
