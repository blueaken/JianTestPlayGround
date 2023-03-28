package lintcode.twopointers;


import type.ListNode;

public class RemoveDuplicatesFromSortedList2_LE_82 {
    /*
        3.28.2023
        - LE 83的进阶版, solve by two pointers, still has details to look after
    */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode slow = dummy, fast = head;
        while (fast != null) {
            if (fast.next != null && fast.val == fast.next.val) {
                // 发现重复节点
                while (fast.next != null && fast.val == fast.next.val) {
                    fast = fast.next;
                }
                // 跳过了当前重复区域，但下一段仍然可能是重复区域，交给while loop下一次iteration判断
                fast = fast.next;
                if (fast == null) {
                    slow.next = null;
                }
            } else {
                // 没有发现重复节点，接入slow后面
                slow.next = fast;
                slow = slow.next;
                fast = fast.next;
            }
        }
        return dummy.next;
    }
}
