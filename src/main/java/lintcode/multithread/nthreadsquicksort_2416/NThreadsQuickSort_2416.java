package lintcode.multithread.nthreadsquicksort_2416;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NThreadsQuickSort_2416 {
    public int[] quickSortInThreadings(int n, int[] arr) throws Exception {
        // write your code here
        List<Object> list = new ArrayList<>();
        ExecutorService pool = Executors.newFixedThreadPool(n);
        CountDownLatch countDownLatch = new CountDownLatch(n);

        int len = arr.length;
        int fixedNum = len / n;
        int extraNum = len % n;

        QuickSort qs = new QuickSort();

        for (int i = 0; i < n; i++) {
            final int start = i * fixedNum;
            int end = start + fixedNum - 1;
            if (i == n - 1 && extraNum > 0) {
                end += extraNum;
            }
            int e = end;
            int subLength = end - start + 1;
            final int[] sub = new int[subLength];
            for (int j = start, k = 0; j <= end && k < subLength; j++, k++) {
                sub[k] = arr[j];
            }
            pool.execute(() -> {
                try {
                    qs.sortRange(sub, 0, subLength - 1);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                list.add(sub);
                countDownLatch.countDown();
            });
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return mergeNSortedArrays(list);
    }

    // Put the arrays to be merged into the list
    public int[] mergeNSortedArrays(List<Object> list) throws Exception {
        List<Integer> ls = new ArrayList<>();
        for (Object oj :list) {
            if(oj == null) continue;
            int arr[] = (int[]) oj;
            for (int num : arr){
                ls.add(num);
            }
        }
        int[] arr = ls.stream().mapToInt(Integer::valueOf).toArray();
        Arrays.sort(arr);
        return arr;
    }
}
