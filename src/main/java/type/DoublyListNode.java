package type;

/**
 * Author: blueaken
 * Date: 5/18/16 09:48
 */
public class DoublyListNode {
    public int val;
    public DoublyListNode next, prev;
    public DoublyListNode(int val) {
        this.val = val;
        this.next = this.prev = null;
    }
}
