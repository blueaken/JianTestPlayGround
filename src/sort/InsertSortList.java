package sort;

/**
 * @author jianshen
 */
public class InsertSortList {
    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode p0; //for loop operation

        ListNode p1 = head;
        ListNode p2 = head.next;
        int swap;
        while(p2 != null){
            if (p1.val < p2.val) { //in order, good!
                p1 = p1.next;
                p2 = p2.next;
                continue;
            }else{ //need to figure where to insert from head
                p0 = head;
                while (p0 != null){
                    if (p0.val > p2.val) {
                        swap = p0.val; p0.val = p2.val; p2.val = swap;
                    }
                    p0 = p0.next;
                }
            }
        }

        return head;
    }

    public static void main(String[] args){
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

        ListNode ln = new ListNode(2);
        ln.next = new ListNode(2);

        ListNode result = ln;

        System.out.println("Linked list before sort: ");
        while (result != null){
            System.out.print(result.val+" ");
            result = result.next;
        }
        System.out.println("");

        result = insertionSortList(ln);

        System.out.println("Linked list after sort: ");
        while (result != null){
            System.out.print(result.val+" ");
            result = result.next;
        }
    }
}
