package lintcode.multithread.nthreadscalsum_2453;

import java.io.FileReader;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class Main {
    private static String mainThreadName;
    private static PrintStream printStream;
    private static List<Integer> arr = new LinkedList<>();
    private static List<Integer> nums = new LinkedList<>();
    private static List<Integer> rangeLen = new LinkedList<>();

    public static void main(String[] args) {
        try {
//            String inputPath = args[0];
//            String outputPath = args[1];
//            Scanner in = new Scanner(new FileReader(inputPath));
//            int n = Integer.parseInt(in.nextLine());
            int n = 10;
//            String arrString = in.nextLine();
//            String[] arrList = arrString.substring(1, arrString.length()-1).split(", ");
//            for(int i = 0; i < arrList.length; i++) {
//                if(arrList[i].charAt(0) == '-') {
//                    arr.add(-1 * Integer.parseInt(arrList[i].substring(1)));
//                }else {
//                    arr.add(Integer.parseInt(arrList[i]));
//                }
//            }
            arr.add(66);
            arr.add(-52);
            arr.add(1);
            arr.add(6);
            arr.add(-87);

            arr.add(-37);
            arr.add(-20);
            arr.add(3);
            arr.add(-2);
            arr.add(47);
            //expect -75

//            printStream = new PrintStream(outputPath);
            mainThreadName = Thread.currentThread().getName();
            Consumer<int[]> appendTheRangeAnswer = (int[] x) -> {
                try {
                    if (mainThreadName == Thread.currentThread().getName()) {
                        Exception exception = new Exception("You should call this method in a sub thread.");
                        throw exception;
                    }
                    int total = 0;
                    for (int i = x[0]; i < x[1]; i++ ) {
                        total += arr.get(i);
                    }
                    if (total != x[2]) {
                        Exception exception = new Exception("You got an incorrect result in calculating arr[" + String.valueOf(x[0]) + ": " + String.valueOf(x[1]) + "].");
                        throw exception;
                    }
                    nums.add(x[2]);
                    rangeLen.add(x[1]-x[0]);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            };
            NThreadsCalSum_2453 solution = new NThreadsCalSum_2453();
            solution.runSumInThread(n, arr, appendTheRangeAnswer);
            int sumNums = 0;
            int sumArr = 0;
            for(int i = 0; i < nums.size(); i++) {
                sumNums += nums.get(i);
            }
            for(int i = 0; i < arr.size(); i++) {
                sumArr += arr.get(i);
            }
            int maxRangeLen = 0;
            int minRangeLen = arr.size();
            for(int i = 0; i < rangeLen.size(); i++) {
                if(rangeLen.get(i) < minRangeLen)
                    minRangeLen = rangeLen.get(i);
                if(rangeLen.get(i) > maxRangeLen)
                    maxRangeLen = rangeLen.get(i);
            }
            if (nums.size() != n) {
                Exception exception = new Exception("You should use n threads to calculate the answer.");
                throw exception;
            }else if (sumNums != sumArr && nums.size() != n) {
                Exception exception = new Exception("You should use n threads to calculate the answer and wait until all threads are finished.");
                throw exception;
            }else if ((maxRangeLen - minRangeLen) >= n) {
                Exception exception = new Exception("You need to balance the amount of calculation for each thread.");
                throw exception;
            }
//            printStream.write(String.valueOf(sumNums).getBytes("Utf-8"));
//            printStream.close();
            System.out.println("total: " + sumNums);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
