package lintcode.multithread.intervalprintwithnumchar_2436;

//import java.io.FileReader;
//import java.io.PrintStream;
import java.util.function.IntConsumer;

public class Main {
    private static String mainThreadName;
//    private static PrintStream ps;
    public static void main(String[] args) {
        try {
//            String inputPath = args[0];
//            String outputPath = args[1];
//            Scanner in = new Scanner(new FileReader(inputPath));
//            ps = new PrintStream(outputPath);
            mainThreadName = Thread.currentThread().getName();
//            IntervalPrintWithNumChar_2436 solution = new IntervalPrintWithNumChar_2436(Integer.parseInt(in.nextLine()));
            IntervalPrintWithNumChar_2436 solution = new IntervalPrintWithNumChar_2436(3);
            IntConsumer printNumber = (int x) -> {
                try {
                    if (mainThreadName == Thread.currentThread().getName() || x < 0) {
                        throw new Exception("You should print numbers in a sub thread.");
                    }
//                    ps.write(String.valueOf(x).getBytes("Utf-8"));
                    System.out.print(x);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            };
            IntConsumer printCharacter = (int x) -> {
                try {
                    if (mainThreadName == Thread.currentThread().getName() || x < 0 || x > 25) {
                        throw new Exception("You should print numbers in a sub thread.");
                    }
//                    ps.write(String.valueOf((char)('A'+x)).getBytes("Utf-8"));
                    System.out.print((char)('A'+x));
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            };
            Thread thread = new Thread(() -> {
                try {
                    solution.number(printNumber);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            Thread thread1 = new Thread(() -> {
                try {
                    solution.character(printCharacter);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            thread.start();
            thread1.start();
            thread.join();
            thread1.join();
//            ps.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
