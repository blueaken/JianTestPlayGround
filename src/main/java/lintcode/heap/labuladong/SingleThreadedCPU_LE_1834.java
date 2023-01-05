package lintcode.heap.labuladong;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SingleThreadedCPU_LE_1834 {
    /**
     1.5.2023
     - 使用PriorityQueue, 但需要平衡三个变量之间的优先级关系：enqueue time, process time, index
     - 可以先根据开始时间排序，因为只有到了开始时间，任务才处于可以执行状态
     - 然后再用 heap 对 process time 和 index进行动态排序
     - 每完成一个任务更新一下当前时间now, 来产生更多的可执行任务
     */
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        List<int[]> triples = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            triples.add(new int[] {tasks[i][0], tasks[i][1], i});
        }

        // sort by enqueue time
        triples.sort((a, b) -> a[0] - b[0]);

        // 1st sort by process time, if same then sort by index number
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            int diff = a[1] - b[1];
            if (diff == 0) {
                diff = a[2] - b[2];
            }
            return diff;
        });

        int now = 0;
        int cur = 0;
        List<Integer> res = new ArrayList<>();
        while (res.size() < n) {
            if (heap.size() > 0) {
                int[] next = heap.poll();
                // add next task index to result
                res.add(next[2]);
                // update now time
                now += next[1];
            } else {
                // if not available task, update now to the most recent task
                if (cur < n && triples.get(cur)[0] > now) {
                    now = triples.get(cur)[0];
                }
            }

            // update available task since "now" updated
            while (cur < n && triples.get(cur)[0] <= now) {
                heap.offer(triples.get(cur));
                cur++;
            }
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }
}
