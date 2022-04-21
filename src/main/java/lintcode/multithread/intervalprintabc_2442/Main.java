package lintcode.multithread.intervalprintabc_2442;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) {
//        try {
//            String inputPath = args[0];
//            String outputPath = args[1];
//
//            Scanner in = new Scanner(new FileReader(inputPath));
//            PrintStream ps = new PrintStream(outputPath);
//            System.setOut(ps);
//            IntervalPrintABC_2442 solution = new IntervalPrintABC_2442(Integer.parseInt(in.nextLine()));
            IntervalPrintABC_2442 solution = new IntervalPrintABC_2442(3);
            new Thread(() -> {
                try {
                    solution.printA();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }).start();
            new Thread(() -> {
                try {
                    solution.printB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }).start();
            new Thread(() -> {
                try {
                    solution.printC();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }).start();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }

    }
}
