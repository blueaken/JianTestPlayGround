package lintcode.linkedlist;

import type.ListNode;

public class RemoveElements_452 {
    /**
     * @param head: a ListNode
     * @param val: An integer
     * @return: a ListNode
     */
    //Idea: 只用一个dummy指针处理即可
    public ListNode removeElements(ListNode head, int val) {
        // write your code here
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        //把头节点给dummy的下一个节点
        dummy.next = head;
        head = dummy;

        while (head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
                //跳过这个节点
            } else {
                head = head.next;
                //跳到下一个节点
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {

        int val = 3;
        //1,3,5
        ListNode ln1 = new ListNode(1);
        ln1.next = new ListNode(3);
        ln1.next.next = new ListNode(5);

        RemoveElements_452 solution = new RemoveElements_452();
        solution.removeElements(ln1, val).print();
    }
}
