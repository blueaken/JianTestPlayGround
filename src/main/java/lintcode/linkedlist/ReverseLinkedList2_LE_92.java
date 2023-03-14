package lintcode.linkedlist;

import type.ListNode;

public class ReverseLinkedList2_LE_92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseN(head, right);
        }

        head.next = reverseBetween(head.next, left-1, right-1);
        return head;
    }

    ListNode succ = null;
    private ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            succ = head.next; //纪录 n+1 node
            return head;
        }

        ListNode last = reverseN(head.next, n-1);
        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = succ;
        return last;
    }

    public static void main(String[] args) {
        ReverseLinkedList2_LE_92 solution = new ReverseLinkedList2_LE_92();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("before reverse:");
        head.print();
        System.out.println("*******************");

        int left = 2, right = 4;
        System.out.println("after reverse:");
        solution.reverseBetween(head, left, right).print();
    }
}
