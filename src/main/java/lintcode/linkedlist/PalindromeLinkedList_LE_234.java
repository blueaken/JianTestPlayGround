package lintcode.linkedlist;

import type.ListNode;

public class PalindromeLinkedList_LE_234 {
    /**
     11.17.2022
     ref 东哥 post
     - 链表兼具递归结构，树结构不过是链表的衍生。那么，链表其实也可以有前序遍历和后序遍历
     - 链表的后序遍历，可以从后向前访问链表
     - 这个解法实际每个节点比较了2次，有优化空间
     */
    ListNode left;
    public boolean isPalindrome(ListNode head) {
        left = head;
        return postTraverse(head);
    }

    private boolean postTraverse(ListNode right) {
        if (right == null) {
            return true;
        }
        boolean res = postTraverse(right.next);
        //处理后序遍历逻辑
        res = res && (left.val == right.val);
        left = left.next;

        return res;
    }
}
