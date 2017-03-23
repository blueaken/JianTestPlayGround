package books.shizhanjvmxuniji.chap6_perf_monitor_tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by jianshen on 3/23/17.
 */
public class HoldIOMain {
    public static class HoldIOTask implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    FileOutputStream fos = new FileOutputStream(new File("/Users/jianshen/tempOOOOO"));
                    for (int i = 0; i < 10000; i++) {
                        fos.write(i);
                    }
                    fos.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class LazyTask implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    Thread.sleep(1000);  //空闲线程
                }
            } catch (Exception e) {

            }
        }
    }

    public static void main(String[] args) {
        new Thread(new HoldIOTask()).start();   //开启线程，占用IO

        new Thread(new LazyTask()).start();      //空闲线程
        new Thread(new LazyTask()).start();
        new Thread(new LazyTask()).start();
    }
}
