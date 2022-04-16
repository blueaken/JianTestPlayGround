package lintcode.multithread.sleepsort_2449;

import java.lang.*;

public class Main {
    static String mainThreadName;

    public static void printNumber(double x) throws Exception {
        if (mainThreadName == Thread.currentThread().getName()) {
            Exception exception = new Exception();
            throw exception;
        } else {
            System.out.println(String.valueOf(x));
            System.out.println(String.valueOf("\n"));
        }
    }

    public static void main(String[] args) {
        try {
            mainThreadName = Thread.currentThread().getName();

            double[] array = {0.17,0.02,0.1};
//            double[] array = {0.1,0.2,0.3};
            SleepSort_2449 sol = new SleepSort_2449();
            sol.sleepSort(array);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
