package lintcode.multithread.intervalprint_2428;

import java.io.*;
import java.util.*;
import java.util.function.IntConsumer;

public class Main {
    public static void main(String[] args) {

        try {
//            String inputPath = args[0];
//            String outputPath = args[1];
//
//            Scanner in = new Scanner(new FileReader(inputPath));
//            PrintStream ps = new PrintStream(outputPath);

//            IntervalPrint_2428 solution = new IntervalPrint_2428(Integer.parseInt(in.nextLine()));
            IntervalPrint_2428 solution = new IntervalPrint_2428(6);

            IntConsumer printEven = (int x) -> {
                try {
                    if (x % 2 != 0) {
                        throw new Exception("passed odd number to printEven in thread for printing even numbers.");
                    }
//                    ps.write(String.valueOf(x).getBytes());
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
//                    ps.write(String.valueOf(x).getBytes());
                    System.out.print(x);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            };

            new Thread(() -> {
                try {
                    solution.even(printEven);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

            new Thread(() -> {
                try {
                    solution.odd(printOdd);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
