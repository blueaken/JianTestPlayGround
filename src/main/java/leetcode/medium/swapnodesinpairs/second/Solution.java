package leetcode.medium.swapnodesinpairs.second;

import type.ListNode;

/**
 * Author: blueaken
 * Date: 2/2/16 10:03 AM
 */
public class Solution {
    public static ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p = dummyHead;
        ListNode q = p.next;

        while(q!=null){
            if (q.next==null) break;

            ListNode r = q.next;
            p.next = r;
            q.next = r.next;
            r.next = q;

            p = q;
            q = p.next;
        }

        return dummyHead.next;
    }

    public static void main(String[] args){
//        //even number
//        ListNode node = new ListNode(1);
//        node.next = new ListNode(2);
//        node.next.next = new ListNode(3);
//        node.next.next.next = new ListNode(4);

        //odd number
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        ListNode res = swapPairs(node);
        while (res!=null){
            System.out.println(res.val + " ");
            res = res.next;
        }
    }
}
