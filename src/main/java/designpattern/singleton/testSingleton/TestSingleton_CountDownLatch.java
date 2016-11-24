package designpattern.singleton.testSingleton;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jianshen on 11/23/16.
 */
public class TestSingleton_CountDownLatch {

    public static void main(String[] args) throws InterruptedException {

        final Set<String> instanceSet = Collections.synchronizedSet(new HashSet<String>());
        final CountDownLatch cdl = new CountDownLatch(1);

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        cdl.await();
                        Singleton_ThreadUnsafe singletonThreadUnsafe = Singleton_ThreadUnsafe.getInstance();
                        instanceSet.add(singletonThreadUnsafe.toString());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });
        }
        Thread.sleep(1000);
        cdl.countDown();
        Thread.sleep(1000);
        System.out.println("------并发情况下我们取到的实例个数------");
        System.out.println(instanceSet.size());
        executorService.shutdown();
    }
}
