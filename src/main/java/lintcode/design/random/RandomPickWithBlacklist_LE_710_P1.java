package lintcode.design.random;

import java.util.Map;
import java.util.HashMap;
import java.util.Random;

public class RandomPickWithBlacklist_LE_710_P1 {
    /**
     12.16.2022
     ref 东哥 post, the idea is put all blacklist into the last range of the array
     ==============
     03.27.2023
     P1
     */
    Map<Integer, Integer> bkMap;
    int size;
    public RandomPickWithBlacklist_LE_710_P1(int n, int[] blacklist) {
        bkMap = new HashMap<>();

        size = n - blacklist.length;
        // put blacklist nums into map
        for (int b : blacklist) {
            bkMap.put(b, -1);
        }

        // map blacklist nums to a good number after size
        int last = n - 1;
        for (int b : blacklist) {
            if (b >= size) {
                continue;
            }

            // get next available last number to map the current blacklist val
            while (bkMap.containsKey(last)) {
                last--;
            }

            bkMap.put(b, last);
            last--;
        }
    }

    public int pick() {
        Random rand = new Random();
        int res = rand.nextInt(size);
        if (!bkMap.containsKey(res)) {
            return res;
        } else {
            return bkMap.get(res);
        }
    }
}
