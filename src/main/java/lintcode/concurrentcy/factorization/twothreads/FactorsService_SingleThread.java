package lintcode.concurrentcy.factorization.twothreads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FactorsService_SingleThread {

    //建立一个因式分解服务
    public void service(Long num) {
        List<Long> factors = factor(num);
    }

    private List<Long> factor(Long num) {
        //时间起点
        long begintime = System.currentTimeMillis();

        Long factor = 2L;
        Long count = 0L;
        Long start = num;
        List<Long> factors = new ArrayList<>();
        while (factor <= num) {
            if (num % factor == 0) {
                num = num / factor;
                factors.add(factor);
            } else {
                factor++;
            }
            count++;
        }
//        System.out.println("计算结束，循环了" + count + "次");

        synchronized (this) {
            //主要是新增了这块的同步，以便于打印控制台消息的时候顺序不会乱
            //因为线程是交替执行的，这部分不同步的话打印会乱序。
            //这部分代码的同步不会影响什么时间，因为主要的时间消耗不在这部分逻辑上
            System.out.print(start + "的因数分解为: ");
            Long var = 1L;
            for (int i = 0; i < factors.size(); i++) {
                System.out.print(factors.get(i));
                if (i < factors.size() - 1) {
                    System.out.print("X");
                }

                var *= factors.get(i);
            }
            System.out.println();
            System.out.println("验证：分解出来因数相乘结果为:" + var);
            long endtime = System.currentTimeMillis();
            System.out.println("耗时" + (endtime - begintime) + "毫秒");
        }
        return factors;
    }

    public static void main(String[] args) {
        FactorsService_SingleThread solution = new FactorsService_SingleThread();

        List<Long> nums = Arrays.asList(1323999999999L, 1323999999999L);
        Long begin=System.currentTimeMillis();
        for (Long num : nums) {
            solution.service(num);
        }
        Long end=System.currentTimeMillis();

        System.out.println("2个任务计算完成，耗时:"+(end-begin)+"毫秒");
    }

}