package leetcode.medium.addtwonumbers;

import type.ListNode;

/**
 * Created by jshe18 on 9/11/15.
 */
public class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        ListNode before = head;
        int curry = 0;
        int l1Val, l2Val;

        while (l1 != null || l2 != null) {
            if (l1==null) {
                l1Val=0;
            }else {
                l1Val=l1.val;
            }

            if (l2==null) {
                l2Val=0;
            }else {
                l2Val=l2.val;
            }

            int val = l1Val + l2Val + curry;
            curry = 0;
            if (val<10){
                p.val = val;
            }else {
                p.val = val%10;
                curry = 1;
            }

            p.next = new ListNode(0);
            before = p;
            p = p.next;

            if (l1!=null){
                l1=l1.next;
            }

            if (l2!=null){
                l2=l2.next;
            }
        }
        before.next = null;

        if (curry == 1){
            before.next = new ListNode(1);
        }

        return head;
    }

    public static void main(String[] args){

        //tc #1
//        ListNode ln1 = new ListNode(2);
//        ln1.next = new ListNode(4);
//        ln1.next.next = new ListNode(3);
//
//        ListNode ln2 = new ListNode(5);
//        ln2.next = new ListNode(6);
//        ln2.next.next = new ListNode(8);

        //tc #2
//        ListNode ln1 = new ListNode(1);
//        ln1.next = new ListNode(9);
//        ln1.next.next = new ListNode(9);
//        ln1.next.next.next = new ListNode(9);
//
//        ListNode ln2 = new ListNode(9);

        //tc #3
        ListNode ln1 = new ListNode(1);
        ln1.next = new ListNode(8);

        ListNode ln2 = new ListNode(9);

        ListNode result = addTwoNumbers(ln1, ln2);
        while (result!=null){
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
