package designpattern.constructor.singleton.testSingleton;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jianshen on 11/22/16.
 */
public class TestSingleton {
    boolean lock;

    public boolean getLock() {
        return this.lock;
    }

    public void setLock(boolean lock) {
        this.lock = lock;
    }

    public static void main(String[] args) throws InterruptedException {
        final Set<String> instanceSet = Collections.synchronizedSet(new HashSet<String>());
        final TestSingleton lock = new TestSingleton();
        lock.setLock(true);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            executorService.execute(new Runnable() {

                public void run() {
                    while (true) {
                        if (!lock.getLock()) {
                            Singleton_ThreadUnsafe singletonThreadUnsafe = Singleton_ThreadUnsafe.getInstance();
                            instanceSet.add(singletonThreadUnsafe.toString());
                            break;
                        }
                    }
                }
            });
        }
        Thread.sleep(5000);
        lock.setLock(false);
        Thread.sleep(5000);
        System.out.println("------并发情况下我们取到的实例个数------");
        System.out.println(instanceSet.size());
        executorService.shutdown();
    }
}
