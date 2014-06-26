/**
 * @author jianshen
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class temp {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode fakeHead = new ListNode(-999);
        fakeHead.next = head;
        ListNode p = fakeHead;

        while (p != null && p.next != null){
            ListNode tmp = p.next;
            ListNode tmpNext = p.next.next;
            while (tmp != null && tmp.val == tmpNext.val){
                tmp = tmp.next;
                tmpNext = tmpNext.next;
            }
            p.next = tmpNext;
            p = p.next;
        }
        return fakeHead.next;
    }

    public static void main(String[] args){
        ListNode ln = new ListNode(1);
        ln.next = new ListNode(1);
        ln.next.next = new ListNode(2);
        ln.next.next.next = new ListNode(3);
        ln.next.next.next.next = new ListNode(4);
        ln.next.next.next.next.next = new ListNode(4);
        ln.next.next.next.next.next.next = new ListNode(5);

//        ListNode ln = new ListNode(1);
//        ln.next = new ListNode(1);
//        ln.next.next = new ListNode(2);
//        ln.next.next.next = new ListNode(2);
//        ln.next.next.next.next = new ListNode(3);
//        ln.next.next.next.next.next = new ListNode(3);
//        ln.next.next.next.next.next.next = new ListNode(4);

        ln = deleteDuplicates(ln);

        while (ln != null){
            System.out.print(ln.val);
            ln = ln.next;
        }
    }

}
