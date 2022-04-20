package lintcode.multithread.intervalprintdec_2433;

import java.util.function.IntConsumer;
// you can import any package you need here
// write your code here
import java.util.concurrent.locks.*;
/*
    similar to 2090, 2428
 */
public class IntervalPrintDec_2433 {
    private int n;
    // you can delcare any attributes here if you need
    // write your code here
    private Lock lock;
    private Condition cond;
    private int state; //0,1,2 indicates next action
    private int start_zero;
    private int start_one;
    private int start_two;

    public IntervalPrintDec_2433(int n) {
        // write your code here
        this.n = n;
        this.lock = new ReentrantLock();
        this.cond = lock.newCondition();
        int remi = n % 3;
        switch (remi) {
            case 0:
                this.state = 0;
                this.start_zero = n;
                this.start_one = n - 2;
                this.start_two = n - 1;
                break;
            case 1:
                this.state = 1;
                this.start_zero = n - 1;
                this.start_one = n;
                this.start_two = n - 2;
                break;
            case 2:
                this.state = 2;
                this.start_zero = n - 2;
                this.start_one = n - 1;
                this.start_two = n;
                break;
        }
    }

    public void remainderZero(IntConsumer printNumber) throws InterruptedException {
        // write your code here
        lock.lock();
        try {
            for (int i = start_zero; i > 0; i-=3) {
                while (state != 0) {
                    cond.await();
                }
                printNumber.accept(i);
                state = 2;
                cond.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }

    public void remainderOne(IntConsumer printNumber) throws InterruptedException {
        // write your code here
        lock.lock();
        try {
            for (int i = start_one; i > 0; i-=3) {
                while (state != 1) {
                    cond.await();
                }
                printNumber.accept(i);
                state = 0;
                cond.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }

    public void remainderTwo(IntConsumer printNumber) throws InterruptedException {
        // write your code here
        lock.lock();
        try {
            for (int i = start_two; i > 0; i-=3) {
                while (state != 2) {
                    cond.await();
                }
                printNumber.accept(i);
                state = 1;
                cond.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }
}
