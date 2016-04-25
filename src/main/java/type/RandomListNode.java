package type;

/**
 * Created by jshe18 on 9/16/15.
 */
public class RandomListNode {
    public int label;
    public RandomListNode next, random;
    public RandomListNode(int x) { this.label = x; }

    public void print() {
        RandomListNode node = this;
        while (node != null) {
            System.out.print(node.label + "->");
            node = node.next;
        }
        System.out.print("null");
        System.out.println();
    }
}
