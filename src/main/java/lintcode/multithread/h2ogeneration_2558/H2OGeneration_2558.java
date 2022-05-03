package lintcode.multithread.h2ogeneration_2558;

import java.util.concurrent.Semaphore;
import java.util.function.Consumer;

/*
    Idea - 使用Semaphore来协调H和O的调用次数，sOxygen.acquire(2) - 表示需要2个permit才能调用一次，可以根据需要进行调整。

         - 体会Semaphore和Lock的本质区别，锁的基本用途还是围绕“共享资源”，如条件锁的功能是防止不停地循环去判断一个共享资源是
           否满足某个条件。而Semaphore则是用于协调多个线程间的执行的逻辑顺序。

    Ref - https://www.zhihu.com/question/47704079
 */
public class H2OGeneration_2558 {
    private Semaphore sHydrogen = new Semaphore(2);
    private Semaphore sOxygen = new Semaphore(1);

    public H2OGeneration_2558() {
        // write your code
    }

    public void hydrogen(Consumer releseHydrogen) {
        // write your code
        try {
            sHydrogen.acquire(1);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        releseHydrogen.accept(0);
        sOxygen.release(1);
    }

    public void oxygen(Consumer releseOxygen) {
        // write your code
        try {
            sOxygen.acquire(2);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        releseOxygen.accept(0);
        sHydrogen.release(2);
    }
}
