package lintcode.multithread.threadsafehashmap_2473;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

/*
    Idea:
          -   similar to 2471, producer & consumer thread safe, with a little trick to
              check if the key exists or not before get operation.

          -   同时本题ThreadSafeHashMap对Size没有要求，作为无边界对象处理，需要判断是否Full。
 */
public class ThreadSafeHashMap_2473 extends AbstractHashMap {
    // write your code
    // private Lock lock;
    // private Semaphore sFull;
    // private Semaphore sEmpty;

    public ThreadSafeHashMap_2473(int baseSize) {
        super(baseSize);
        // write your code
        // lock = new ReentrantLock();
        // sFull = new Semaphore(baseSize);
        // sEmpty = new Semaphore(0);
    }

    public synchronized void put(int key, int value) {
        // modify the following code
        // try {
        // sFull.acquire();
        // lock.lock();
        super.put(key, value);
        // lock.unlock();
        // sEmpty.release();
        // } catch (InterruptedException ex) {
        //     ex.printStackTrace();
        // }

    }

    public synchronized  int get(int index) {
        // modify the following code
        // int val = 0;
        // try {
        //     sEmpty.acquire();
        //     lock.lock();
        //     val = super.get(index);
        //     lock.unlock();
        //     sFull.release();
        // } catch (InterruptedException ex) {
        //     ex.printStackTrace();
        // }
        // return val;

        return super.get(index);
    }
}