package lintcode.multithread.intervalprint_2428;

import java.util.function.IntConsumer;
// you can import any package you need here
// -- write your code here --
import java.util.concurrent.locks.*;

/*
    similar to 2090
*/

public class IntervalPrint_2428 {
    // you can delcare any attributes here if you need
    // -- write your code here --
    int num;
    int state = 1; //1, 2 indicates next action
    Lock lock;
    Condition cond;

    public IntervalPrint_2428(int n) {
        // -- write your code here --
        this.num = n;
        this.lock = new ReentrantLock();
        this.cond = lock.newCondition();
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        // -- write your code here --
        lock.lock();
        try {
            for (int i = 1; i <= num; i+=2) {
                while (state != 1) {
                    cond.await();
                }
                printNumber.accept(i);
                this.state = 2;
                cond.signalAll();
            }

        } finally {
            lock.unlock();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        // -- write your code here --
        lock.lock();
        try {
            for (int i = 2; i <= num; i+=2) {
                while (state != 2) {
                    cond.await();
                }
                printNumber.accept(i);
                this.state = 1;
                cond.signalAll();
            }

        } finally {
            lock.unlock();
        }
    }
}
