package lintcode.multithread.threadsafelinkedlist_2471;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
    Idea: similar to 2462, 但本题不需要协调appendLeft与appendRight之间的关系，不需要
          使用信号量；但由于在Main中使用多个线程调用appendLeft与appendRight方法，因此
          需要用同一把锁来解决线程竞争关系。
*/
public class ThreadSafeLinkedList_2471 {
    private volatile ListNode head;
    private Lock lock;

    public ThreadSafeLinkedList_2471(){
        // write your code
        this.head = null;
        this.lock = new ReentrantLock();
    }

    public void appendLeft(int element){
        // write your code
        // the element given to be append left
        lock.lock();
        if (head == null) {
            head = new ListNode(element);
        } else {
            ListNode node = new ListNode(element);
            node.setNext(head);
            head = node;
        }
        lock.unlock();
        return;
    }

    public void appendRight(int element){
        // write your code
        // the element given to be append right
        lock.lock();
        if (head == null) {
            head = new ListNode(element);
        } else {
            ListNode node = head;
            while (node.getNext() != null) {
                node = node.getNext();;
            }
            node.setNext(new ListNode(element));
        }
        lock.unlock();
        return;
    }

    public ListNode getLinkedList(){
        // write your code
        // return the head of the linked list
        return this.head;
    }
}
