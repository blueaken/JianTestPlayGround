package leetcode.medium.swapnodesinpairs;

import type.ListNode;

/**
 * Author: blueaken
 * Date: 9/12/15 7:53 AM
 */
public class Solution_CleanCode {
    public static ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-999);
        dummyHead.next = head;
        ListNode previous = dummyHead;
        ListNode cur = dummyHead.next;

        while (cur!=null && cur.next!=null){
            ListNode after = cur.next;
            ListNode afterNext = after.next;

            previous.next = after;
            after.next = cur;
            cur.next = afterNext;

            previous = cur;
            cur = afterNext;
        }

        return dummyHead.next;
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
