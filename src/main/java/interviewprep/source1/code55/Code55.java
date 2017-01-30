package interviewprep.source1.code55;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

/**
 * Created by jianshen on 1/12/17.
 */
public class Code55 {
    //注意两点：
    //1. 对同一变量多线程操作时，具体方法要加synchronized同步
    //2. 在幂名内部类中使用实例变量，实例变量需要声明为final，确保内部类的copy和外部一致

    public static void main(String[] args) {

        final JobManager jobManager = new JobManager();
        for (int i = 0; i < 2; i++) {
            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        jobManager.inc();
                    }
                }
            });
            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        jobManager.dec();
                    }
                }
            });

            thread1.start();
            thread2.start();
        }

    }
}

class JobManager {
    private int j;

    public synchronized void inc() {
        j++;
        System.out.println(j);
    }

    public synchronized void dec() {
        j--;
        System.out.println(j);
    }
}
