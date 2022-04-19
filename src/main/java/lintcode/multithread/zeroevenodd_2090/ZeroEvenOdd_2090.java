package lintcode.multithread.zeroevenodd_2090;

import java.util.concurrent.locks.*;
import java.util.function.IntConsumer;

/*
  注意IntComsumer类，是Java 8开始提供的基于Lambda表达式方法调用，也常用于线程(ref 1)。
  通过锁来实现同步，在zero方法里控制逻辑(ref 2)

  Ref - https://www.geeksforgeeks.org/intconsumer-interface-in-java-with-examples/
      - https://www.lintcode.com/problem/2090/solution/55862
*/
public class ZeroEvenOdd_2090 {
    // you can delcare any attributes here if you need
    // -- write your code here --
    private int num;
    private int state = 0; //0,1,2 indicates next action
    private Lock lock;
    private Condition condition;

    public ZeroEvenOdd_2090(int n) {
        // n represents the sequence size you need to print
        // if n = 2, your code should call the following method one by one
        // printZero(0)
        // printOdd(1)
        // printZero(0)
        // printEven(2)
        // you can do any initialization you need here.

        // -- write your code here --
        this.num = n;
        this.lock = new ReentrantLock();
        this.condition = lock.newCondition();
    }

    public void zero(IntConsumer printZero) throws InterruptedException {
        // printZero.accept(x) outputs "x", where x is 0.
        // if x is not 0, printZero will throw exception, check the logic in Main.java

        // -- write your code here --
        lock.lock();
        try {
            for (int i = 1; i <= num; i++) {
                while (state != 0) {
                    condition.await();
                }
                printZero.accept(0);
                if (i % 2 == 1) {
                    this.state = 1;
                } else {
                    this.state = 2;
                }
                condition.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }

    public void even(IntConsumer printEven) throws InterruptedException {
        // printEven.accept(x) outputs "x", where x is an even number.
        // if x is not even, printEven will throw exception, check the logic in Main.java

        // --  write your code here --
        lock.lock();
        try {
            for (int i = 2; i <= num; i+=2) {
                while (state != 2) {
                    condition.await();
                }
                printEven.accept(i);
                this.state = 0;
                condition.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }

    public void odd(IntConsumer printOdd) throws InterruptedException {
        // printOdd.accept(x) outputs "x", where x is an odd number.
        // if x is not odd, printOdd will throw exception, check the logic in Main.java

        // --  write your code here --
        lock.lock();
        try {
            for (int i = 1; i <= num; i+=2) {
                while (state != 1) {
                    condition.await();
                }
                printOdd.accept(i);
                this.state = 0;
                condition.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }
}
