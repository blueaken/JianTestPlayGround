package lintcode.linkedlist;

import type.ListNode;

import java.util.PriorityQueue;

public class MergeKSortedLists_LE_23_P1 {
    /*
        - ref previous solution, a straightforward way is to use min heap, keep iterate until the heap size is empty
        - Time is O(nlogk), n - is the number of all ListNodes in the final list, k is the number of linked lists, since every poll and offer to the heap takes O(logk).
        - Space is O(n) + O(k), for the result list and priority queue.
    */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                minHeap.offer(lists[i]);
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

    public static void main(String[] args) {
        MergeKSortedLists_LE_23_P1 solution = new MergeKSortedLists_LE_23_P1();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] listNodes = new ListNode [] {l1, l2, l3};

        solution.mergeKLists(listNodes).print();
    }
}
