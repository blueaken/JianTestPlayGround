package lintcode.multithread.threadsaftcounter_2503;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* idea - 本题只有线程竞争，没有线程协调，只用锁就可以了，没有2497复杂
        - 除了synchronized之外，用ReentrantLock实现了一次，参考这篇关于两者的区别
        - https://zhuanlan.zhihu.com/p/126085068
*/
public class ThreadSafeCounter_2503 {
    private int i;
    // write your code
    private Lock lock;

    public ThreadSafeCounter_2503() {
        this.i = 0;
        // write your code
        lock = new ReentrantLock();
    }

    public void incr() {
        // write your code
        lock.lock();
        i = Main.incr();
        lock.unlock();
    }

    public void decr() {
        // write your code
        lock.lock();
        i = Main.decr();
        lock.unlock();
    }

    public int getCount() {
        return i;
    }
}
