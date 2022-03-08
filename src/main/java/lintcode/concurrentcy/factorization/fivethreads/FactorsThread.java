package lintcode.concurrentcy.factorization.fivethreads;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class FactorsThread implements Runnable {

    private CountDownLatch latch;

    public FactorsThread(CountDownLatch latch) {
        this.latch = latch; //初始化闭锁
    }

    FactorsService_SingleThread factorsService;

    public void setFactorsService(FactorsService_SingleThread factorsService) {
        this.factorsService = factorsService;
    }

    Long num = 0L;
    public void setNum(Long num) {
        this.num = num;
    }

    public void run() {
        factorsService.service(num);
        latch.countDown();  //CountDownLatch在执行完run后减1
    }

    public static void main(String[] args) {
        FactorsService_SingleThread factorsService = new FactorsService_SingleThread();

        //开始时间
        List<Long> nums = Arrays.asList(1323999999999L, 1323999999999L,1323999999999L, 1323999999999L, 1323999999999L); //51323999999999L, 51323999999999L, 51323999999998L);
        Long begin=System.currentTimeMillis();
        for (Long num : nums) {
            factorsService.service(num);
        }
        Long end=System.currentTimeMillis();
        System.out.println("5个任务计算完成，耗时:"+(end-begin)+"毫秒");

        //创建CountDownLatch对象，2表示最终要同步的是2个线程
        final CountDownLatch latch = new CountDownLatch(2);
        FactorsThread factorsThread = new FactorsThread(latch);
        factorsThread.setFactorsService(factorsService);

        System.out.println("多线程的方式启动计算：");
        Long beginThread = System.currentTimeMillis();
        for (Long num : nums) {
            factorsThread.setNum(num);
            Thread thread = new Thread(factorsThread);//新建线程
            thread.start();
        }

        try {
            //多线程运行结束前一直等待
            latch.await(); //闭锁的作用，阻塞等待 直到countDown为0
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //结束时间
        Long endThread = System.currentTimeMillis();
        System.out.println("多线程任务计算完成! 耗时" + (endThread - beginThread) + "毫秒");
    }

}
