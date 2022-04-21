package lintcode.multithread.intervalprintwithnthreads_2438;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntConsumer;

public class Main {
    public static void main(String[] args) throws Exception {

        try {
//            String inputPath = args[0];
//            String outputPath = args[1];
//            Scanner in = new Scanner(new FileReader(inputPath));
//            PrintStream ps = new PrintStream(outputPath);
//
//            //Editable
//            int n = Integer.parseInt(in.next());
//            int m = Integer.parseInt(in.next());
            int n = 3;
            int m = 6;
            IntervalThreadsWithNThreads_2438 solution = new IntervalThreadsWithNThreads_2438(n,m);
            List<Thread> ls = new ArrayList<>();
            for (int i = 0; i < n; i++){
                IntConsumer printZero = (int x) -> {
                    try {
                        int id = Integer.parseInt(Thread.currentThread().getName());
                        if ((x-1) % n != id){
                            throw new Exception("You passed x={" + x + "} which remainder number not fit the thread: {" + id +"}");
                        }
//                        ps.print(x);
                        System.out.print(x);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.exit(1);
                    }
                };
                Thread thread = new Thread(()->{
                    try {
                        solution.printThreadNumber(printZero);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }, String.valueOf(i));
                thread.start();
                ls.add(thread);
            }

            //Editable end
            for (Thread td : ls){
                td.join();
            }
//            ps.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
