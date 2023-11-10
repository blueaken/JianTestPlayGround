package lintcode.linkedlist;

import type.ListNode;

public class InsertToCircularLinkedList_LE_708 {
    /**
     11.10.23
     - ref https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/solutions/1517181/java-solution-one-pass-with-comments/
     */
    public ListNode insert(ListNode head, int insertVal) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode node = new ListNode(insertVal);

        if (head == null) {
            // empty list
            dummy.next = node;
            node.next = node;
        } else if (head.next == head) {
            // single node
            head.next = node;
            node.next = head;
        } else {
            ListNode pre = head;
            ListNode next = head.next;

            while (true) {
                // ascending
                if (pre.val <= next.val) {
                    if (pre.val <= insertVal && insertVal <= next.val) {
                        pre.next = node;
                        node.next = next;
                        break;
                    }
                } else if (pre.val > next.val) {
                    // at cliff
                    if (pre.val <= insertVal || insertVal <= next.val) {
                        pre.next = node;
                        node.next = next;
                        break;
                    }
                }

                pre = next;
                next = next.next;

                if (next == head) {
                    // circle back to head, all nodes equals
                    pre.next = node;
                    node.next = next;
                    break;
                }
            }
        }

        return dummy.next;

    }

    public static void main(String[] args) {
        InsertToCircularLinkedList_LE_708 solution = new InsertToCircularLinkedList_LE_708();
        ListNode head = new ListNode(3);
        ListNode next = new ListNode(4);
        ListNode nn = new ListNode(1);
        head.next = next;
        next.next = nn;
        nn.next = head;
        int val = 2;

        solution.insert(head, val).print();
    }
}
