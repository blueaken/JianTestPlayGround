package sort;

/**
 * Created with IntelliJ IDEA.
 * User: blueaken
 * Date: 6/24/14
 * Time: 11:59 下午
 */

/**
 * Definition for singly-linked list.
 */
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
}

public class DistinctList {
    /*
     * less elegant solution
     */
//    public static ListNode deleteDuplicates(ListNode head) {
//        if (head == null) return null;
//        ListNode p = head;
//        int current = p.val;
//        int next;
//        while (p.next != null){
//            next = p.next.val;
//            if (current == next){
//                ListNode start = p;
//                while (p.next != null && p.next.val == current){
//                    p = p.next;
//                }
//                start.next = p.next;
//            } else{
//                current = next;
//                p = p.next;
//            }
//        }
//        return head;
//    }

    /**
     * more elegant solution
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = head;
        while (p != null){
            ListNode tmp = p.next;
            while (tmp != null && tmp.val == p.val){
                tmp = tmp.next;
            }
            p.next = tmp;
            p = p.next;
        }
        return head;
    }

    public static void main(String[]args){
        ListNode ln = new ListNode(1);
        ln.next = new ListNode(2);
        ln.next.next = new ListNode(2);
        ln.next.next.next = new ListNode(2);
        ln.next.next.next.next = new ListNode(2);
        ln.next.next.next.next.next = new ListNode(3);

        ListNode result = deleteDuplicates(ln);
        while (result!=null){
            System.out.print(result.val);
            result = result.next;
        }
    }
}
