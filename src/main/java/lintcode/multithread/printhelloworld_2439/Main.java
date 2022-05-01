package lintcode.multithread.printhelloworld_2439;

import java.io.IOException;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) {

//        try {
//            String inputPath = args[0];
//            String outputPath = args[1];
//
//            PrintStream ps = new PrintStream(outputPath);
//            System.setOut(ps);

            PrintHelloWorld_2439 solution = new PrintHelloWorld_2439();

            new Thread(() -> {
                try {
                    solution.printHello();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();

            new Thread(() -> {
                try {
                    solution.printWorld();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();

//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
    }
}
