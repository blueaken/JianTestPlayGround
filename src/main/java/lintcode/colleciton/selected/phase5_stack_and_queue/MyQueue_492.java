package lintcode.colleciton.selected.phase5_stack_and_queue;

import type.ListNode;

public class MyQueue_492 {
    ListNode head;
    /*
     * @param item: An integer
     * @return: nothing
     */
    public void enqueue(int item) {
        // write your code here
        if (head == null) {
            head = new ListNode(item);
        } else {
            ListNode temp = new ListNode(item);
            ListNode node = head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = temp;
        }
    }

    /*
     * @return: An integer
     */
    public int dequeue() {
        // write your code here
        if (head == null) {
            return Integer.MIN_VALUE;
        }
        int ret = head.val;
        head = head.next;
        return ret;
    }
}
