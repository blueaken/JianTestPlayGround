package lintcode.multithread.nthreadscalsum_2453;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class NThreadsCalSum_2453 {
    public void runSumInThread(int n, List<Integer> arr, Consumer<int[]> appendTheRangeAnswer) throws Exception {
        // write your code
        ExecutorService pool = Executors.newFixedThreadPool(n);
        CountDownLatch countDownLatch = new CountDownLatch(n);
        int len = arr.size();
        int fixedNum = len / n;
        int extraNum = len % n;


        for (int i = 0; i < n; i++) {
            int[] x = new int[3];
            x[0] = i * fixedNum;
            x[1] = x[0] + fixedNum;
            if (i == n - 1 && extraNum > 0) {
                x[1] += extraNum;
            }
            int sum = 0;
            for (int j = x[0]; j < x[1]; j++ ) {
                sum += arr.get(j);
            }
            x[2] = sum;

            pool.execute(() -> {
                appendTheRangeAnswer.accept(x);
                countDownLatch.countDown();
            });
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pool.shutdown();
    }
}
