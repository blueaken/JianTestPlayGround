package lintcode.linkedlist;

import type.ListNode;

import java.util.PriorityQueue;

public class MergeKSortedLists_LE_23_P2 {
    /*
        - ref previous solution, a straightforward way is to use min heap, keep iterate until the heap size is empty
        - Time is O(nlogk), n - is the number of all ListNodes in the final list, k is the number of linked lists, since every poll and offer to the heap takes O(logk).
        - Space is O(n) + O(k), for the result list and priority queue.
        ===================
        P2 11.16.2022
        redo ref 东哥 post
        ===================
    */
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if (k == 0) {
            return null;
        }

        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (int i = 0; i < k; i++) {
            if (lists[i] != null) {
                heap.offer(lists[i]);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (heap.size() > 0) {
            ListNode cur = heap.poll();
            p.next = cur;
            p = p.next;

            if (cur.next != null) {
                heap.offer(cur.next);
            }
        }
        return dummy.next;
    }
}
