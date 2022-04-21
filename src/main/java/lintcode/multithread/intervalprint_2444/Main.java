package lintcode.multithread.intervalprint_2444;

import java.io.FileReader;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) {
        try {
//            String inputPath = args[0];
//            String outputPath = args[1];
//            Scanner in = new Scanner(new FileReader(inputPath));
//            PrintStream stdout = new PrintStream(outputPath);
//            System.setOut(stdout);


//            String[] params = in.nextLine().split(" ");
//            IntervalPrint_2444 solution = new IntervalPrint_2444(Integer.parseInt(params[0]));
            IntervalPrint_2444 solution = new IntervalPrint_2444(80);

            new Thread(() -> {
                try {
                    solution.printFirst();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            new Thread(() -> {
                try {
                    solution.printSecond();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            new Thread(() -> {
                try {
                    solution.printThird();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();


        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
