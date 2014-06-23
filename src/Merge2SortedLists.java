
/**
 * Created with IntelliJ IDEA.
 * User: blueaken
 * Date: 6/22/14
 * Time: 4:32 下午
 */

public class Merge2SortedLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null && l2 != null) return l2;
        if (l1 != null && l2 == null) return l1;

        ListNode tempHead = new ListNode (-9999);
        ListNode point = tempHead;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val) {
                point.next = l1;
                point = point.next;
                if (l1.next != null)
                    l1 = l1.next;
                else
                {
                    //add the rest of l2 and quit loop
                    point.next = l2;
                    break;
                }
            }else {
                point.next = l2;
                point = point.next;
                if (l2.next != null)
                    l2 = l2.next;
                else
                {
                    //add the result of l1 and quit loop
                    point.next = l1;
                    break;
                }
            }
        }

        return tempHead.next;
    }

    public static void main(String[] args){
        //1,3,5
        ListNode ln1 = new ListNode(1);
        ln1.next = new ListNode(3);
        ln1.next.next = new ListNode(5);

        //2,4,6
        ListNode ln2 = new ListNode(2);
        ln2.next = new ListNode(4);
        ln2.next.next = new ListNode(6);

        //1,2,3,4,5,6
        ListNode result = mergeTwoLists(ln1, ln2);
        while (result!=null){
            System.out.print(result.val);
            result = result.next;
        }

        //2 null nodes
        ListNode nullNode1 = null;
        ListNode nullNode2 = null;
        result = mergeTwoLists(nullNode1, nullNode2);
        System.out.println("");
        if (result==null){
            System.out.println("return null result as expected");
        }

        //1 null node
        ListNode zeroNode = new ListNode(0);
        result = mergeTwoLists(nullNode1, zeroNode);
        while (result!=null){
            System.out.print(result.val);
            result = result.next;
        }
        System.out.println("");
    }
}
