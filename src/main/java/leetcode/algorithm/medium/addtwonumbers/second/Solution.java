package leetcode.algorithm.medium.addtwonumbers.second;

import type.ListNode;

/**
 * Author: blueaken
 * Date: 2/1/16 9:11 AM
 */
public class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead;

        int carry = 0;
        while(l1!=null || l2!=null){
            if (l1!=null && l2!=null){
                int value = l1.val + l2.val + carry;
                carry = 0;
                if (value>9){
                    carry = 1;
                    value %= 10;
                }
                p.next = new ListNode(value);
                p = p.next;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l2!=null){
                int value = l2.val + carry;
                carry = 0;
                if (value>9){
                    carry = 1;
                    value %= 10;
                }
                p.next = new ListNode(value);
                p = p.next;
                l2 = l2.next;
            } else if (l1!=null){
                int value = l1.val + carry;
                carry = 0;
                if (value>9){
                    carry = 1;
                    value %= 10;
                }
                p.next = new ListNode(value);
                p = p.next;
                l1 = l1.next;
            }
        }

        if (carry==1) {
            p.next = new ListNode(1);
            p = p.next;
        }

        return dummyHead.next;
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
