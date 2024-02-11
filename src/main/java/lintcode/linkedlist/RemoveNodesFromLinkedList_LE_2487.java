package lintcode.linkedlist;

import type.ListNode;

import java.util.LinkedList;

public class RemoveNodesFromLinkedList_LE_2487 {
    /**
     2.1.24
     */
    public ListNode removeNodes(ListNode head) {
        LinkedList<Integer> list = new LinkedList<>();

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode p = dummy.next;
        while (p != null) {
            while (list.size() != 0 && list.getLast() <= p.val) {
                list.removeLast();
            }
            list.addLast(p.val);
            p = p.next;
        }

        if (list.size() != 0) {
            p = dummy;
            while (p.next != null && list.size() > 0) {
                int top = list.getFirst();
                if (p.next.val != top) {
                    // remove p.next
                    p.next = p.next.next;
                } else {
                    list.removeFirst();
                    p = p.next;
                }
            }
        }
        return dummy.next;

    }

    public static void main(String[] args) {
        RemoveNodesFromLinkedList_LE_2487 solution = new RemoveNodesFromLinkedList_LE_2487();
        ListNode head = new ListNode(5);
        head.next = new ListNode(2);
        head.next.next = new ListNode(13);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(8);

        solution.removeNodes(head).print();
    }

}
