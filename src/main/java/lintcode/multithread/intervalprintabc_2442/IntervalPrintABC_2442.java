package lintcode.multithread.intervalprintabc_2442;

import java.util.concurrent.Semaphore;

public class IntervalPrintABC_2442 {
    // write your code here
    private int n;
    private Semaphore sA = new Semaphore(1);
    private Semaphore sB = new Semaphore(0);
    private Semaphore sC = new Semaphore(0);

    public IntervalPrintABC_2442(int n) {
        // write your code here
        this.n = n;
    }

    public void printA() throws InterruptedException {
        // write your code here
        for (int i = 1; i <= n; i++) {
            sA.acquire();
            System.out.print('A');
            sB.release();
        }
    }

    public void printB() throws InterruptedException {
        // write your code here
        for (int i = 1; i <= n; i++) {
            sB.acquire();
            System.out.print('B');
            sC.release();
        }
    }

    public void printC() throws InterruptedException {
        // write your code here
        for (int i = 1; i <= n; i++) {
            sC.acquire();
            System.out.print('C');
            sA.release();
        }
    }
}
