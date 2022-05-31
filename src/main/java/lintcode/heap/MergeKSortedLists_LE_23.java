package lintcode.heap;

import java.util.PriorityQueue;

import type.ListNode;

public class MergeKSortedLists_LE_23 {
    /*
        - ref previous solution, a straightforward way is to use min heap, keep iterate until the heap size is empty
        - Time is O(nlogk), n - is the number of all ListNodes in the final list, k is the number of linked lists, since every poll and offer to the heap takes O(logk).
        - Space is O(n) + O(k), for the result list and priority queue.
    */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (minHeap.size() > 0) {
            ListNode cur = minHeap.poll();
            p.next = cur;
            p = p.next;
            if (cur.next != null) {
                minHeap.offer(cur.next);
            }
        }
        return dummy.next;
    }
}
