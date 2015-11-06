package type;

/**
 * Created by jshe18 on 11/6/15.
 */
public class MinStackNode {
    private int val;
    private int min;
    private MinStackNode next;

    public MinStackNode(int v) {
        val = v;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public MinStackNode getNext() {
        return next;
    }

    public void setNext(MinStackNode next) {
        this.next = next;
    }
}
