package books.shizhanjvmxuniji.chap8_lock_and_concurrency;

import java.util.List;
import java.util.Vector;

/**
 * Created by jianshen on 3/8/17.
 */
//run with: -XX:+UseBiasedLocking -XX:BiasedLockingStartupDelay=0 -client
public class Biased {
    public static List<Integer> numberList = new Vector<>();

    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        int count = 0;
        int startnum = 0;
        while (count < 10000000) {
            numberList.add(startnum);
            startnum += 2;
            count++;
        }
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }
}
