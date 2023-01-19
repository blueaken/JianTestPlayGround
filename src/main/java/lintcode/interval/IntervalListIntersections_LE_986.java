package lintcode.interval;

import java.util.LinkedList;
import java.util.List;

public class IntervalListIntersections_LE_986 {
    /**
     1.19.2023
     ref 东哥 post, Interval问题一般看起来复杂，但只要分情况讨论分析，一般是能找到一个比较简洁的逻辑关系的
     */
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0, j = 0;
        List<int[]> res = new LinkedList<>();
        while (i < firstList.length && j < secondList.length) {
            int a1 = firstList[i][0], a2 = firstList[i][1];
            int b1 = secondList[j][0], b2 = secondList[j][1];

            if (b2 >= a1 && a2 >= b1) {
                // 如果存在交集
                int[] merge = new int[] {Math.max(a1, b1), Math.min(a2, b2)};
                res.add(merge);
            }

            if (a2 < b2) {
                i++;
            } else {
                j++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
