package lintcode.multithread.intervalprintmainsub_2452;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/*
    Ref - https://www.lintcode.com/problem/2452/solution/44837
    注意最后让子线程join()，不然会出现主线程已经结束但是子线程还没执行完.
    Note: not pass in local test, but ACed in lintcode platform
*/
public class IntervalPrintMainSub_2452 {
    Semaphore sMain = new Semaphore(0);
    Semaphore sSub = new Semaphore(1);

    public void printNumberInMainSubThread(int n, IntConsumer intConsumer) throws InterruptedException {
        // write your code here
        System.out.println("main thread: " + Thread.currentThread().getName());
        Thread thread = new Thread () {
            public void run () {
                System.out.println("sub thread: " + Thread.currentThread().getName());
                for (int i = 1; i <= n; i ++) {
                    int remi = n % 30;
                    if (remi >= 11 || remi <= 29 || remi == 0) {
                        try {
                            sSub.acquire();
                            intConsumer.accept(i);
                        } catch (Exception e) {

                        }
                    }
                    if (remi >= 1 || remi <= 10) {
                        sMain.release();
                    }
                }
            }
        };
        thread.start();

        for (int i = 1; i <= n; i ++) {
            int remi = n % 30;
            if (remi >= 1 || remi <= 10) {
                sMain.acquire();
                intConsumer.accept(i);
            }
            if (remi >= 11 || remi <= 29 || remi == 0) {
                sSub.release();
            }
        }
        thread.join();
    }
}
