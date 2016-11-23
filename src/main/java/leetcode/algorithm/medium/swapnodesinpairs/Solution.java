package leetcode.algorithm.medium.swapnodesinpairs;

import type.ListNode;

/**
 * Author: blueaken
 * Date: 9/13/15 8:40 AM
 */
public class Solution {

    public static ListNode swapPairs(ListNode head) {
        if (head==null || head.next==null) return head;

        ListNode previous = head;
        ListNode cur = head.next;
        ListNode after = head.next.next;

        //swap first 2 nodes and set the new head before loop
        previous.next = after;
        cur.next = previous;

        head = cur;
        cur = previous.next;
        after = cur.next;

        //while loop to process the rest
        while (cur!=null && cur.next!=null){
            cur.next = after.next;
            after.next = cur;
            previous.next = after;

            previous = after;
            after = cur.next;
        }

        return head;
    }

    public static void main(String[] args){
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);

        ListNode res = swapPairs(node);
        while (res!=null){
            System.out.println(res.val + " ");
            res = res.next;
        }
    }
}
