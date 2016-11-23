package type;

/**
 * Author: blueaken
 * Date: 2/9/15 8:26 下午
 */
public class DoubleLinkedListNode {
    int key;
    int value;
    DoubleLinkedListNode prev;
    DoubleLinkedListNode next;

    public DoubleLinkedListNode(int key, int value) {
        this.key = key;
        this.value = value;
        prev = null;
        next = null;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public DoubleLinkedListNode getPrev() {
        return prev;
    }

    public void setPrev(DoubleLinkedListNode prev) {
        this.prev = prev;
    }

    public DoubleLinkedListNode getNext() {
        return next;
    }

    public void setNext(DoubleLinkedListNode next) {
        this.next = next;
    }
}
