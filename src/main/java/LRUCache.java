import type.DoubleLinkedListNode;

import java.util.HashMap;

/**
 * Author: blueaken
 * Date: 2/9/15 8:25 下午
 */
// ref: http://blog.csdn.net/whuwangyi/article/details/15495845
public class LRUCache {
    private HashMap<Integer, DoubleLinkedListNode> hashMap = new HashMap<Integer, DoubleLinkedListNode>();
    private DoubleLinkedListNode head;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    //Detach a node from the double linked list
    private void detach(DoubleLinkedListNode node){
        if (node == this.head){ //corner case
            this.head = node.getNext();
        }

        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());
    }

    //Attach a node to the head of the double linked list
    private void attach(DoubleLinkedListNode node){
        node.setNext(this.head);
        this.head.setPrev(node);

        this.head = node;
    }
}
