package lintcode.multithread.h2ogeneration_2558;

import java.io.*;
import java.util.Scanner;
import java.util.function.Consumer;

class ReleaseThread extends Thread{
    private int n;
    private boolean isOxygen;
    private H2OGeneration_2558 h2o;
//    private PrintWriter writer;

//    public ReleaseThread(int n, boolean isOxygen, H2OGeneration_2558 h2o, PrintWriter writer) {
public ReleaseThread(int n, boolean isOxygen, H2OGeneration_2558 h2o) {
        super();
        this.n = n;
        this.isOxygen = isOxygen;
        this.h2o = h2o;
//        this.writer = writer;
    }

    @Override
    public void run() {
        Consumer<Integer> releaseHydrogen = (x) -> {
            try {
//                writer.write("H");
                System.out.print("H");
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        };

        Consumer<Integer> releaseOxygen = (x) -> {
            try {
//                writer.write("O");
                System.out.print("O");
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        };

        if (isOxygen) {
            for(int i = 0; i < n; i++) {
                h2o.oxygen(releaseOxygen);
            }
        } else {
            for(int i = 0; i < n; i++) {
                h2o.hydrogen(releaseHydrogen);
            }
        }

    }
}

//class Driver extends BaseDriver {
class Driver {
//    public Driver(String inputPath, String outputPath) throws IOException {
//        super(inputPath, outputPath);
//    }

//    public String doSpecialJudge(String inputData, String outputData) {
//        String[] params = inputData.split(" ");
//        int n = Integer.parseInt(params[1]);
//        int counts = 0;
//        for (int i = 0; i < n; i++) {
//            String substr = outputData.substring(i * 3, i * 3 + 3);
//            if (!substr.equals("HHO") && !substr.equals("HOH") && !substr.equals("OHH")) {
//                return substr + " is not a h2o";
//            }
//            counts++;
//        }
//        if(counts != n)
//            return "You only produced " + String.valueOf(counts) + " h2o.\nWe need " + String.valueOf(n) + " h2o";
//        return "";
//    }

    public void run() throws IOException {
//        String inputData = scanner.nextLine();
//        String[] params = inputData.split(" ");
//        int h = Integer.parseInt(params[0]);
//        int o = Integer.parseInt(params[1]);

        int h = 6;
        int o = 3;

        H2OGeneration_2558 solution = new H2OGeneration_2558();

//        ReleaseThread hThread = new ReleaseThread(h, false, solution, writer);
//        ReleaseThread oThread = new ReleaseThread(o, true, solution, writer);
        ReleaseThread hThread = new ReleaseThread(h, false, solution);
        ReleaseThread oThread = new ReleaseThread(o, true, solution);

        hThread.start();
        oThread.start();
        try {
            hThread.join();
            oThread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

//        writer.close();
        System.out.println();
//
//        specialJudge(inputData);
    }
}
