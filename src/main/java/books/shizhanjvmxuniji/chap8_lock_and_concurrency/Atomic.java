package books.shizhanjvmxuniji.chap8_lock_and_concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * Created by jianshen on 3/9/17.
 */
public class Atomic {
    private static final int MAX_THREADS = 3;
    private static final int TASK_COUNT = 3;
    private static final int TARGET_COUNT = 10000000;

    private AtomicLong account = new AtomicLong(0L);
    private long count = 0;
    private LongAdder lAccount = new LongAdder();

    static CountDownLatch cdlsync = new CountDownLatch(TASK_COUNT);
    static CountDownLatch cdlatomic = new CountDownLatch(TASK_COUNT);
    static CountDownLatch cdladdr = new CountDownLatch(TASK_COUNT);

    //有锁的加法
    protected synchronized long inc() {
        return ++count;
    }

    //有锁的读操作
    protected synchronized long getCount() {
        return count;
    }

    public void clearCount() {
        count = 0;
    }

    public class SyncThread implements Runnable {
        protected String name;
        protected long starttime;
        Atomic out;
        public SyncThread(Atomic o, long starttime) {
            this.out = o;
            this.starttime = starttime;
        }

        @Override
        public void run() {
            long v = out.getCount();
            while (v < TARGET_COUNT) {
                v = out.inc();
            }
            long endtime = System.currentTimeMillis();
            System.out.println("SyncThread spend:" + (endtime - starttime) + "ms" + " v=" +v);
            cdlsync.countDown();
        }
    }

    public void testSync() throws InterruptedException{
        ExecutorService exe = Executors.newFixedThreadPool(MAX_THREADS);
        long starttime = System.currentTimeMillis();
        SyncThread sync = new SyncThread(this, starttime);
        for (int i = 0; i < TASK_COUNT; i++) {
            exe.submit(sync);
        }
        cdlsync.await();
        exe.shutdown();
    }

    public class AtomicThread implements Runnable {
        protected String name;
        protected long starttime;
        public AtomicThread(long starttime) {
            this.starttime = starttime;
        }

        @Override
        public void run() {
            long v = account.get();
            while (v < TARGET_COUNT) {
                v = account.incrementAndGet();
            }
            long endtime = System.currentTimeMillis();
            System.out.println("AtomicThread spend:" + (endtime - starttime) + "ms" + " v=" +v);
            cdlatomic.countDown();
        }
    }

    public void testAtomic() throws InterruptedException{
        ExecutorService exe = Executors.newFixedThreadPool(MAX_THREADS);
        long starttime = System.currentTimeMillis();
        AtomicThread atomic = new AtomicThread(starttime);
        for (int i = 0; i < TASK_COUNT; i++) {
            exe.submit(atomic);
        }
        cdlatomic.await();
        exe.shutdown();
    }

    public class LongAdderThread implements Runnable {
        protected String name;
        protected long starttime;
        public LongAdderThread(long starttime) {
            this.starttime = starttime;
        }

        @Override
        public void run() {
            long v = lAccount.sum();
            while (v < TARGET_COUNT) {
                lAccount.increment();
                v = lAccount.sum();
            }
            long endtime = System.currentTimeMillis();
            System.out.println("LongAdderThread spend:" + (endtime - starttime) + "ms" + " v=" +v);
            cdladdr.countDown();
        }
    }

    public void testLongAdderAtomic() throws InterruptedException{
        ExecutorService exe = Executors.newFixedThreadPool(MAX_THREADS);
        long starttime = System.currentTimeMillis();
        LongAdderThread longAdderThread = new LongAdderThread(starttime);
        for (int i = 0; i < TASK_COUNT; i++) {
            exe.submit(longAdderThread);
        }
        cdladdr.await();
        exe.shutdown();
    }

    public static void main(String[] args) throws InterruptedException {
        Atomic atomic = new Atomic();
        atomic.testSync();
        atomic.testAtomic();
        atomic.testLongAdderAtomic();
    }
}
