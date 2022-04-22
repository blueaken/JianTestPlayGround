package lintcode.multithread.intervalprintmainsub_2452;

import java.io.FileReader;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.function.IntConsumer;

public class Main {
    public static void main(String[] args) {
        try {
//            String inputPath = args[0];
//            String outputPath = args[1];
//            Scanner in = new Scanner(new FileReader(inputPath));
//            PrintStream ps = new PrintStream(outputPath);
//
//            int n = Integer.parseInt(in.nextLine());

            IntConsumer intConsumer = (x->{
                try {
                    int num = x % 30;
//                    String name = Thread.currentThread().getName();
//                    if ((num >= 11 && num <= 30 || num == 0) && "main".equals(name)){
//                        throw new Exception("You should call this method in a sub thread when you passed x=" + x + " , current thread name: " + name);
//                    }
//                    if (num >= 1 && num <= 10 && !"main".equals(name)){
//                        throw new Exception("You should call this method in main thread when you passed x=" + x + " , current thread name: " + name);
//                    }
//                    ps.write(String.valueOf(x).getBytes(StandardCharsets.UTF_8));
                    System.out.print(x);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            IntervalPrintMainSub_2452 solution = new IntervalPrintMainSub_2452();
            solution.printNumberInMainSubThread(18,intConsumer);
//            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
