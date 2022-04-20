package lintcode.multithread.intervalprintwithnumchar_2436;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;
//you can import any package you need here
//write your code

/*
    similar to 2090, 2428, 2433, try Semaphore this time, looks more neat

    Ref - https://www.lintcode.com/problem/2428/solution/33696
        - https://blog.csdn.net/ds19980228/article/details/89094882
*/
public class IntervalPrintWithNumChar_2436 {
    private int n;
    private Semaphore sn = new Semaphore(1);
    private Semaphore sc = new Semaphore(0);

    public IntervalPrintWithNumChar_2436(int n) {
        this.n = n;
    }

    public void number(IntConsumer printNumber) throws Exception {
        // write your code
        for (int i = 0; i < n; i ++) {
            sn.acquire();
            printNumber.accept(2 * i + 1);
            printNumber.accept(2 * i + 2);
            sc.release();
        }
    }

    public void character(IntConsumer printCharacter) throws Exception {
        // write your code
        for (int i = 0; i < n; i ++) {
            sc.acquire();
            printCharacter.accept(i);
            sn.release();
        }
    }
}
