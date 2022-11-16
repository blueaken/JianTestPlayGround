package lintcode.linkedlist;

import type.ListNode;

public class RemoveNthFromEnd_LE_19 {
    /**
     11.16.2022
     ref 东哥 post
     - solve it with one pass
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //有了dummy node方便处理corner case，如链表长5, 要删除倒数第5个node这种情况
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        //找到倒数第n+1个node，进行删除操作
        ListNode x = findFromEnd(dummy, n+1);
        x.next = x.next.next;

        return dummy.next;
    }

    private ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }

        ListNode p2 = head;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        // p2现在指向倒数第 k 个节点
        return p2;
    }
}
