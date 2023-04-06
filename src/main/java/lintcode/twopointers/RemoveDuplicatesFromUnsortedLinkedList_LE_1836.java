package lintcode.twopointers;

import java.util.HashMap;
import java.util.Map;

import type.ListNode;

public class RemoveDuplicatesFromUnsortedLinkedList_LE_1836 {
    /**
     03.29.2023
     - have to traverse twice, one for the count, since it is unsorted
     - ref 东哥 post, some detail to look after
     */
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        Map<Integer, Integer> count = new HashMap<>();
        ListNode p = head;
        while (p != null) {
            count.put(p.val, count.getOrDefault(p.val, 0) + 1);
            p = p.next;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        p = dummy;
        while (p != null) {
            ListNode unique = p.next;
            while (unique != null && count.get(unique.val) > 1) {
                unique = unique.next;
            }
            p.next = unique;
            p = p.next;
        }
        return dummy.next;
    }
}
