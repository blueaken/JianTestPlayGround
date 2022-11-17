package lintcode.linkedlist;

import type.ListNode;

public class PalindromeLinkedList_LE_234_ByReverseList {
    /**
     11.17.2022
     ref 东哥 post
     - 链表兼具递归结构，树结构不过是链表的衍生。那么，链表其实也可以有前序遍历和后序遍历
     - 链表的后序遍历，可以从后向前访问链表
     - 这个解法实际每个节点比较了2次，有优化空间
     ==============================
     - 使用回转链表的方法，比上面的解法时间上更优化
     ==============================
     */
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //如果fast不为null, 链表为奇数，slow节点向后一位
        if (fast != null) {
            slow = slow.next;
        }

        ListNode left = head;
        ListNode right = reverse(slow);
        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head, nxt = head;
        while (cur != null) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}
