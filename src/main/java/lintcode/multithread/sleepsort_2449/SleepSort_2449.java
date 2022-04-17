package lintcode.multithread.sleepsort_2449;

//Ref - https://www.lintcode.com/problem/2449/solution/34696
//    - https://www.lintcode.com/problem/2449/solution/36546
//    - https://blog.csdn.net/zmazon/article/details/8514088
//    join()原理参考source code讲解，ref - https://blog.csdn.net/u010983881/article/details/80257703
public class SleepSort_2449 {
    public void sleepSort(double[] nums) throws Exception {
        // write your code
        Thread[] sortThreads = new Thread[nums.length];
        for (int i = 0; i < sortThreads.length; i++) {
            sortThreads[i] = new Thread(new SortThread(nums[i]));
            sortThreads[i].start();
        }
        // important: must join all the threads to make sure main thread is still alive
        //            while the printNumber method called.
        for (Thread t: sortThreads) {
            t.join();
        }
    }
}

class SortThread implements Runnable {
    double ms = 0;
    public SortThread (double ms) {
        this.ms = ms;
    }

    public void run() {
        try {
            Thread.sleep((int)(ms*1000));
            Main.printNumber(ms);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}