package ninechapter_algorithm.chapter6_linkedlist.sortlist;

import type.ListNode;

/**
 * Author: blueaken
 * Date: 4/24/16 9:10 AM
 */
public class Solution_MergeSort {
    /**
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
    using constant space complexity.
     */
    public static ListNode sortList(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = findMidNode(head);
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);

        return merge(left, right);
    }

    private static ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                node.next = left;
                left = left.next;
            } else {
                node.next = right;
                right = right.next;
            }
            node = node.next;
        }
        //利用链表的性质可以直接挂上
        if (left != null) {
            node.next = left;
        }
        if (right != null) {
            node.next = right;
        }

        return dummy.next;
    }

    // 1->2->3 return 2
    // 1->2 return 1
    //注意，如果FAST = HEAD的话会死循环。可以另外返回一个PreSlow来解决。可以看以前写得 SORT.SORTLIS里面的处理方法
    private static ListNode findMidNode(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main (String[] args){
//        //3,45,57,23,15,39,78,22
//        ListNode ln = new ListNode(3);
//        ln.next = new ListNode(45);
//        ln.next.next = new ListNode(57);
//        ln.next.next.next = new ListNode(23);
//        ln.next.next.next.next = new ListNode(15);
//        ln.next.next.next.next.next = new ListNode(39);
//        ln.next.next.next.next.next.next = new ListNode(78);
//        ln.next.next.next.next.next.next.next = new ListNode(22);
//        ln.next.next.next.next.next.next.next.next = new ListNode(15);
//        ln.next.next.next.next.next.next.next.next.next = new ListNode(57);

        //1,3,2
        ListNode ln = new ListNode(1);
        ln.next = new ListNode(3);
        ln.next.next = new ListNode(2);

        sortList(ln).print();

    }
}
