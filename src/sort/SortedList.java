package sort;

/**
 * @author jianshen
 */
public class SortedList {
    //要求时间为O(nlogn)，最适合就是merge sort，每次从n/2处断开，对两段递归sort，然后再merge起来。空间是O(logn)用了栈空间
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        //find the middle point of the linked list
        ListNode slow = head;
        ListNode fast = head;
        ListNode preSlow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            preSlow = slow;
            slow = slow.next;
        }

        //create 2 linked list (head & head2) from the previous result
        ListNode head2 = slow;
        preSlow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(head2);

        ListNode result = merge(left, right);

        return result;
    }

    private static ListNode merge(ListNode l, ListNode r){
        ListNode tempHead = new ListNode(-999);
        ListNode p = tempHead;
        while (l != null && r != null){
            if (l.val < r.val){
                p.next = new ListNode(l.val);
                l = l.next;
                p = p.next;
            }
            else{
                p.next = new ListNode(r.val);
                r = r.next;
                p = p.next;
            }
        }

        while (l != null) {
            p.next = new ListNode(l.val);
            l = l.next;
            p = p.next;
        }

        while (r != null) {
            p.next = new ListNode(r.val);
            r = r.next;
            p = p.next;
        }

        return tempHead.next;
    }

    public static void main (String[] args){
        //3,45,57,23,15,39,78,22
        ListNode ln = new ListNode(3);
        ln.next = new ListNode(45);
        ln.next.next = new ListNode(57);
        ln.next.next.next = new ListNode(23);
        ln.next.next.next.next = new ListNode(15);
        ln.next.next.next.next.next = new ListNode(39);
        ln.next.next.next.next.next.next = new ListNode(78);
        ln.next.next.next.next.next.next.next = new ListNode(22);
        ln.next.next.next.next.next.next.next.next = new ListNode(15);
        ln.next.next.next.next.next.next.next.next.next = new ListNode(57);

        ListNode result = ln;

        System.out.println("Linked list before sort: ");
        while (result != null){
            System.out.print(result.val+" ");
            result = result.next;
        }
        System.out.println("");

        result = sortList(ln);

        System.out.println("Linked list after sort: ");
        while (result != null){
            System.out.print(result.val+" ");
            result = result.next;
        }
    }
}
