package lintcode.design;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class FrequencyStack_LE_895 {
    /*
    - similar to 460. LFU Cache, also refer to 花花讲义 - https://zxi.mytechroad.com/blog/desgin/leetcode-895-maximum-frequency-stack/
    - idea is to use multiple stacks, one frequency per stack, similar to 460, we use one frequency per queue
    * */

    Map<Integer, Integer> freq; //Node, Freq
    Map<Integer, Stack<Integer>> group; //Freq, Node Stack
    int maxfreq;

    public FrequencyStack_LE_895

            () {
        freq = new HashMap<>();
        group = new HashMap<>();
        this.maxfreq = 0;
    }

    public void push(int val) {
        int f = freq.getOrDefault(val, 0) + 1;
        freq.put(val, f);

        Stack<Integer> stack = group.getOrDefault(f, new Stack<Integer>());
        stack.push(val);
        group.put(f, stack);

        maxfreq = Math.max(maxfreq, f);
    }

    public int pop() {
        if (maxfreq == 0) {
            return Integer.MIN_VALUE;
        }

        Stack<Integer> stack = group.get(maxfreq);
        int val = stack.pop();
        if (stack.isEmpty()) {
            group.remove(maxfreq);
            maxfreq--;
        }

        int f = freq.get(val) - 1;
        if (f == 0) {
            freq.remove(val);
        } else {
            freq.put(val, f);
        }

        return val;
    }
}
