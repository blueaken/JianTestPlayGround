package lintcode.multithread.tenthreadscalsum_2451;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class TenThreadsCalSum_2451 {

    public void runSumInThread(int n, Consumer<Long[]> calculateRangeSum) {
        // write your code
        ExecutorService pool = Executors.newFixedThreadPool(10);
        CountDownLatch countDownLatch = new CountDownLatch(10);
        int fixedNum = n / 10;
        int extraNum = n % 10;

        for (int i = 0; i < 10; i++) {
            Long[] x = new Long[2];
            x[0] = i * fixedNum + 1L;
            x[1] = x[0] + fixedNum - 1L;
            if (i == 9 && extraNum > 0) {
                x[1] += (long)extraNum;
            }

            pool.execute(() -> {
                calculateRangeSum.accept(x);
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