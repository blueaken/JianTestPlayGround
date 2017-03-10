package books.shizhanjvmxuniji.chap8_lock_and_concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by jianshen on 3/8/17.
 */
public class ThreadUnSafe {
    public static List<Integer> numberList = new ArrayList<>();
    //fix solution 1:
//    public static Vector<Integer> numberList = new Vector<>();
    public static class AddToList implements Runnable {
        int startnum = 0;
        public AddToList (int startnumber) {
            startnum = startnumber;
        }

        @Override
        public void run() {
            int count = 0;
            while (count < 1000000) {
                //fix solution 2:
              //  synchronized (AddToList.class) {
                    numberList.add(startnum);
              //  }
                startnum += 2;
                count++;
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new AddToList(0));
        Thread t2 = new Thread(new AddToList(1));
        t1.start();
        t2.start();
    }
}
