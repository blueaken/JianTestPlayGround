package lintcode.multithread.createLog_2504;

import java.util.concurrent.*;

/*Idea - 将原代码改为运行16个线程，同时处理第1~16条日志即可，因为调用了Main中的方法，最后不要忘了join.
       - 试一下用ThreadPool来做,这时使用CountDownLatch来实现join效果(ref 1&2)。关于CountDownLatch和join
       - 的区别，是CountDownLatch的颗粒度比较细(ref3),和ReentrantLock相似。
  Ref  - https://juejin.cn/post/6987576686472593415
       - https://www.lintcode.com/problem/2504/solution/41702
       - https://blog.csdn.net/zhutulang/article/details/48504487
*/
public class CreateLog_2504 {
    public static void createLog() throws Exception {
        // modify the following code
        ExecutorService pool = new ThreadPoolExecutor(16, 20, 3000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        CountDownLatch countDownLatch = new CountDownLatch(16);
        for (int i = 1; i <= 16; i++) {
            final int temp = i;
            pool.execute(() -> {
                Main.parseLog(temp);
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
