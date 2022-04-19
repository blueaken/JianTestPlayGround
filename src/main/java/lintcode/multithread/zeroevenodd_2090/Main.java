package lintcode.multithread.zeroevenodd_2090;

import java.util.function.IntConsumer;

public class Main {
    public static void main(String[] args) {
        int input = 5;
        ZeroEvenOdd_2090 zeroEvenOdd = new ZeroEvenOdd_2090(input);

        IntConsumer printZero = (int x) -> {
            try {
                if (x != 0) {
                    throw new Exception("passed x != 0 to printZero in thread for printing zeroes.");
                }
                System.out.print(x);
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        };
        IntConsumer printEven = (int x) -> {
            try {
                if (x % 2 != 0) {
                    throw new Exception("passed odd number to printEven in thread for printing even numbers.");
                }
                System.out.print(x);
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        };
        IntConsumer printOdd = (int x) -> {
            try {
                if (x % 2 != 1) {
                    throw new Exception("passed even number to printOdd in thread for printing odd numbers.");
                }
                System.out.print(x);
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        };

        new Thread(() -> {
            try {
                zeroEvenOdd.zero(printZero);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.odd(printOdd);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.even(printEven);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
