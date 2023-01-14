package lintcode.design.random;

import java.util.Map;
import java.util.HashMap;
import java.util.Random;

public class RandomPickWithBlacklist_LE_710 {
    /**
     12.16.2022
     ref 东哥 post, the idea is put all blacklist into the last range of the array
     */
    Random rand;
    int size;
    Map<Integer, Integer> map; //black list value, valid index
    public RandomPickWithBlacklist_LE_710(int n, int[] blacklist) {
        rand = new Random();
        size = n - blacklist.length;
        map = new HashMap<>();

        //mark blacklist values
        for (Integer black : blacklist) {
            map.put(black, -1);
        }

        int last = n - 1; //note - should not be "size - 1", since last should cover the range of the whole array
        for (Integer black : blacklist) {
            if (black >= size) {
                continue;
            }

            while (map.containsKey(last)) {
                last--;
            }
            map.put(black, last);
            last--;
        }
    }

    public int pick() {
        int res = rand.nextInt(size);
        if (!map.containsKey(res)) {
            return res;
        } else {
            return map.get(res);
        }
    }
}
