package lintcode.others.treeset;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class ExamRoom_LE_855 {
    /**
     1.27.2023
     - ref 东哥 post, 需要添加和删除，使用TreeSet(二叉排序树)比Heap更合适
     - 将座位之间看成一条线段，初始化一个虚拟线段，类似链表的虚拟表头技巧
     */

    Map<Integer, int[]> startMap;
    Map<Integer, int[]> endMap;
    TreeSet<int[]> pq;
    int N;

    public ExamRoom_LE_855(int n) {
        this.N = n;
        startMap = new HashMap<>();
        endMap = new HashMap<>();
        pq = new TreeSet<>((a, b) -> {
            int disA = getDistance(a);
            int disB = getDistance(b);
            if (disA == disB) {
                // 降序排列，index小的排在后面，从last position访问
                return b[0] - a[0];
            }

            // 升序排列，从last position访问
            return disA - disB;
        });

        // 初始化一条虚拟线段
        addInterval(new int[] {-1, N});
    }

    private int getDistance(int[] interval) {
        int x = interval[0];
        int y = interval[1];
        if (x == -1) {
            return y;
        }
        if (y == N) {
            return N-1-x;
        }
        // 返回中点和端点长度，以处理 0 ...4 ...9 这种情况
        return (y - x) / 2;
    }

    private void addInterval(int[] interval) {
        int x = interval[0];
        int y = interval[1];
        startMap.put(x, interval);
        endMap.put(y, interval);
        pq.add(interval);
    }

    private void removeInterval(int[] interval) {
        int x = interval[0];
        int y = interval[1];
        startMap.remove(x);
        endMap.remove(y);
        pq.remove(interval);
    }

    public int seat() {
        int[] longest = pq.last();
        int x = longest[0];
        int y = longest[1];
        int seat;
        if (x == -1) {
            seat = 0;
        } else if (y == N) {
            seat = N-1;
        } else {
            seat = x + (y - x) / 2;
        }

        // cut the longest into 2 intervals
        int[] left = new int[] {x, seat};
        int[] right = new int[] {seat, y};
        removeInterval(longest);
        addInterval(left);
        addInterval(right);

        return seat;
    }

    public void leave(int p) {
        int[] left = endMap.get(p);
        int[] right = startMap.get(p);
        removeInterval(left);
        removeInterval(right);

        // after leave merge the left and right interval into a longer one
        int[] merge = new int[]{left[0], right[1]};
        addInterval(merge);
    }
}
