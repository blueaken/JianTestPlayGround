package lintcode.multithread.intervalprint_2444;

import java.util.concurrent.Semaphore;

/*
  Note - not AC due to the test when n = 71, no problem in local test, move on
 */
public class IntervalPrint_2444 {
    // you can delcare any attributes here if you need
    // -- write your code here --
    private int n;
    private volatile int cur = 0;
    private Semaphore s1 = new Semaphore(1);
    private Semaphore s2 = new Semaphore(0);
    private Semaphore s3 = new Semaphore(0);

    public IntervalPrint_2444(int n) {
        // n represents the sequence size you need to print
        // if n = 1, your code should call the following method one by one
        // printFirst(1)
        // printFirst(2)
        // printFirst(3)
        // printFirst(4)
        // printFirst(5)
        // printSecond(6)
        // printSecond(7)
        // printSecond(8)
        // printSecond(9)
        // printSecond(10)
        // printThird(11)
        // printThird(12)
        // printThird(13)
        // printThird(14)
        // printThird(15)
        // you can do any initialization you need here.
        // -- write your code here --
        this.n = n;
    }

    public void printFirst() throws InterruptedException {
        // -- write your code here --
        while (cur < n) {
            s1.acquire();
            if (cur < n) { //判断第二次，防止其他线程改变cur值
                for (int i = 1; i <= 5; i++) {
                    System.out.print(cur * 5 + i);
                }
                cur++;
            }
            s2.release();
        }
    }

    public void printSecond() throws InterruptedException {
        // --  write your code here --
        while (cur < n) {
            s2.acquire();
            if (cur < n) { //判断第二次，防止其他线程改变cur值
                for (int i = 1; i <= 5; i++) {
                    System.out.print(cur * 5 + i);
                }
                cur++;
            }
            s3.release();
        }
    }

    public void printThird() throws InterruptedException {
        // --  write your code here --
        while (cur < n) {
            s3.acquire();
            if (cur < n) { //判断第二次，防止其他线程改变cur值
                for (int i = 1; i <= 5; i++) {
                    System.out.print(cur * 5 + i);
                }
                cur++;
            }
            s1.release();
        }
    }
}
