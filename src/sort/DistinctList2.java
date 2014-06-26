package sort;

/**
 * Created with IntelliJ IDEA.
 * User: blueaken
 * Date: 6/25/14
 * Time: 10:34 下午
 */
public class DistinctList2 {
//idea is to create a pre point in addition
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;

        ListNode root = new ListNode(-99999);
        root.next = head;
        ListNode lastValidate = root,pre = head;
        head = head.next;
        while(head != null){
            if(head.val == pre.val){
                while(head != null && head.val == pre.val){
                    head = head.next;
                }
                lastValidate.next = head;
                if(head != null){
                    pre = head;
                    head = head.next;
                }
            }else{
                lastValidate = pre;
                pre = head;
                head = head.next;
            }
        }
        return root.next;
    }

    public static void main(String[] args){
//        ListNode ln = new ListNode(1);
//        ln.next = new ListNode(2);
//        ln.next.next = new ListNode(2);
//        ln.next.next.next = new ListNode(3);
//        ln.next.next.next.next = new ListNode(4);
//        ln.next.next.next.next.next = new ListNode(5);
//        ln.next.next.next.next.next.next = new ListNode(5);
//        ln.next.next.next.next.next.next.next = new ListNode(6);

        ListNode ln = new ListNode(1);
        ln.next = new ListNode(1);
        ln.next.next = new ListNode(2);
        ln.next.next.next = new ListNode(2);
        ln.next.next.next.next = new ListNode(3);
        ln.next.next.next.next.next = new ListNode(3);
        ln.next.next.next.next.next.next = new ListNode(4);

        ln = deleteDuplicates(ln);

        while (ln != null){
            System.out.print(ln.val);
            ln = ln.next;
        }
    }
}
