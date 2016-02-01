package leetcode.medium.addtwonumbers.second;

import type.ListNode;

/**
 * Author: blueaken
 * Date: 2/1/16 9:42 AM
 */
public class Solution_Optimized {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead;

        int carry = 0;
        while(l1!=null || l2!=null){
            int l1Val = l1==null? 0: l1.val;
            int l2Val = l2==null? 0: l2.val;

            int curVal = l1Val + l2Val + carry;
            carry = curVal / 10;
            int value = curVal % 10;
            p.next = new ListNode(value);
            p = p.next;

            if (l1!=null){
                l1 = l1.next;
            }
            if (l2!=null){
                l2 = l2.next;
            }
        }

        if (carry==1) {
            p.next = new ListNode(1);
        }

        return dummyHead.next;
    }

    public static void main(String[] args){

        //tc #1
        ListNode ln1 = new ListNode(2);
        ln1.next = new ListNode(4);
        ln1.next.next = new ListNode(3);

        ListNode ln2 = new ListNode(5);
        ln2.next = new ListNode(6);
        ln2.next.next = new ListNode(4);

        //tc #2
//        ListNode ln1 = new ListNode(1);
//        ln1.next = new ListNode(9);
//        ln1.next.next = new ListNode(9);
//        ln1.next.next.next = new ListNode(9);
//
//        ListNode ln2 = new ListNode(9);

        //tc #3
//        ListNode ln1 = new ListNode(1);
//        ln1.next = new ListNode(8);

//        ListNode ln2 = new ListNode(9);

        ListNode result = addTwoNumbers(ln1, ln2);
        while (result!=null){
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
