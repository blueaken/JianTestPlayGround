package books.shizhanjvmxuniji.chap6_perf_monitor_tools;

/**
 * Created by jianshen on 3/23/17.
 */
public class HoldCPUMain {
    public static class HoldCPUTask implements Runnable {
        @Override
        public void run() {
            while(true) {
                double a = Math.random() * Math.random(); //占用CPU
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
        new Thread(new HoldCPUTask()).start();   //开启线程，占用CPU
        new Thread(new HoldCPUTask()).start();
        new Thread(new HoldCPUTask()).start();

        new Thread(new LazyTask()).start();      //空闲线程
        new Thread(new LazyTask()).start();
        new Thread(new LazyTask()).start();
    }
}
