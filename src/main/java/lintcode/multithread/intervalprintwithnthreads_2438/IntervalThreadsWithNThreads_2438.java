package lintcode.multithread.intervalprintwithnthreads_2438;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/*
   try attack with Semaphore, ref - https://www.lintcode.com/problem/2438/solution/37221
 */
public class IntervalThreadsWithNThreads_2438 {
    private int n;
    private int m;
    int top = 1;
    private Semaphore semaphore = new Semaphore(1);

    public IntervalThreadsWithNThreads_2438(int n, int m){
        this.n = n;
        this.m = m;
    }

    public void printThreadNumber(IntConsumer intConsumer) throws InterruptedException {
        int threadId = Integer.parseInt(Thread.currentThread().getName());
//         System.out.println(threadId);
            while (top <= m) {
                semaphore.acquire();
                if ((top - 1) % n == threadId && top <= m) { //需要判断第二次"top <= m", 因为top可能被其他线程改变值
                    intConsumer.accept(top++);
                }
                semaphore.release();
            }

    }
}
