package lintcode.multithread.boundedblockingqueue_2462;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
    Idea: - BlockinngQueue(无界阻塞队列)和BoundedBlockingQueue(有界阻塞队列)的区别
            在于无界队列只需要判断队列是否为空，有界队列除了是否为空外还需要判断队列是否
            满.

          - Semaphore用来协调不同功能的线程方法间先后处理逻辑，Lock用来处理多个线程
            对同一个线程方法的先后访问关系。对本题，在Main中只有2个线程并各自分别调用enqueue
            和dequeue方法，相当于对每个方法只有一个线程在调用，因此可以只用Semaphore来
            协调，而不使用Lock。

          - 如果对方法enqueue或者dequeue存在多个线程同时调用，则需要在Semaphore之外，加上
            Lock来处理。可以写完现在版本之后在加上Lock练习一下。

     Ref - https://blog.csdn.net/u011436427/article/details/117484320

*/
public class BoundedBlockingQueue_2462 {
    private LinkedList<Integer> list;
    private int capacity;
    private volatile int size;

    private Semaphore sProducer;
    private Semaphore sConsumer;
    private Lock lock;


    public BoundedBlockingQueue_2462(int capacity){
        this.list = new LinkedList();
        this.capacity = capacity;
        this.size = 0;

        //初始状态时，由于队列是空的，可以生产的产品个数等于capacity
        this.sProducer = new Semaphore(capacity);
        //初始状态时，由于队列是空的，可以消费的产品个数等于0
        this.sConsumer = new Semaphore(0);
        //防止多线程调用同一个方法enqueue,或者dequeue, optional
        lock = new ReentrantLock();
    }

    // Add data in relative columns
    public void enqueue(int element){
        try {
            //若队列不满，就可以进行生产了，直到队列满了，生产操作Blocked
            sProducer.acquire();
            lock.lock();
                list.add(element);// add the element to the end of current list
                size++;
            lock.unlock();
            //只要生产了一个产品，队列不空，就可以通知消费者进行消费
            sConsumer.release();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    // Get the data in the queue head
    public int dequeue(){
        int val = 0;
        try {
            //若队列中没有产品，则消费操作Blocked, 直到收到生产者通知
            sConsumer.acquire();
            lock.lock();
                val = list.removeFirst();//remove the 1st element of the linked list
                size--;
            lock.unlock();
            //只要消费了一个产品，队列有空间了，就可以通知生产者进行生产
            sProducer.release();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        return val;
    }

    // Get the size of the queue
    public int size(){
        return this.size;
    }
}
