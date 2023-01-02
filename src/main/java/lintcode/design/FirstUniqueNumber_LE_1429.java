package lintcode.design;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class FirstUniqueNumber_LE_1429 {
    /**
     1.2.2023
     - 这道题需要维护插入元素的顺序 showFirstUnique()使用，并且需要快速判断插入元素是否唯一
     - 使用 Queue来维护插入顺序，使用HashMap来快速判断是否唯一
     */

    LinkedList<Integer> queue = new LinkedList<>();
    Map<Integer, Integer> count = new HashMap<>();

    public FirstUniqueNumber_LE_1429(int[] nums) {
        for (int i : nums) {
            add(i);
        }
    }

    public int showFirstUnique() {

        while(queue.size() > 0) {
            int cur = queue.peekFirst();
            if (count.get(cur) > 1) {
                // 队列中的非唯一元素都弹出, 提高后续查找的效率
                queue.pollFirst();
            } else {
                // 直到找到第一个唯一元素
                return cur;
            }
        }
        //if queue is empty then there is no unique number
        return -1;
    }

    public void add(int value) {
        queue.addLast(value);
        int valCount = count.getOrDefault(value, 0);
        count.put(value, valCount + 1);
    }
}
