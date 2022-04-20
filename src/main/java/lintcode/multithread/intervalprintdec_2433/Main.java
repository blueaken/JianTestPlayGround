package lintcode.multithread.intervalprintdec_2433;

import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.function.IntConsumer;

public class Main {
//    private static PrintStream ps;
    public static void main(String[] args) {
        try {
//            String inputPath = args[0];
//            String outputPath = args[1];
//            Scanner in = new Scanner(new FileReader(inputPath));
//            ps = new PrintStream(outputPath);
//            IntervalPrintDec_2433 solution = new IntervalPrintDec_2433(Integer.parseInt(in.nextLine()));
            IntervalPrintDec_2433 solution = new IntervalPrintDec_2433(5);
            IntConsumer printZero = (int x) -> {
                try {
                    if (x % 3 != 0) {
                        throw new Exception("passed !Zero number to printZero in thread for printing !Zero numbers.");
                    }
//                    ps.write(String.valueOf(x).getBytes("Utf-8"));
                    System.out.print(x);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            };
            IntConsumer printOne = (int x) -> {
                try {
                    if (x % 3 != 1) {
                        throw new Exception("passed !One number to printOne in thread for printing !One numbers.");
                    }
//                    ps.write(String.valueOf(x).getBytes("Utf-8"));
                    System.out.print(x);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            };
            IntConsumer printTwo = (int x) -> {
                try {
                    if (x % 3 != 2) {
                        throw new Exception("passed !Two number to printTwo in thread for printing !Two numbers.");
                    }
//                    ps.write(String.valueOf(x).getBytes("Utf-8"));
                    System.out.print(x);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            };
            Thread[] threads = new Thread[3];
            threads[0] = new Thread(() -> {
                try {
                    solution.remainderZero(printZero);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            threads[1] = new Thread(() -> {
                try {
                    solution.remainderOne(printOne);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            threads[2] = new Thread(() -> {
                try {
                    solution.remainderTwo(printTwo);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            for(int i = 0; i < 3; i++) {
                threads[i].start();
            }
            for(int i = 0; i < 3; i++) {
                threads[i].join();
            }
//            ps.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
