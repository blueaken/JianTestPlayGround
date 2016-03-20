package ninechapter_system_design.chapter2_database_design.consistenthashing2;

import java.util.*;

/**
 * Author: blueaken
 * Date: 3/20/16 4:03 PM
 */
public class Solution {
    // @param n a positive integer
    // @param k a positive integer
    // @return a Solution object
    private static int totalNum;
    private static int shardNum;
    private static Map<Integer, Integer> map;

    public static Solution create(int n, int k) {
        // Write your code here
        Solution solution = new Solution();
        Solution.totalNum = n;
        Solution.shardNum = k;
        Solution.map = new HashMap<>();

        return solution;
    }

    // @param machine_id an integer
    // @return a list of shard ids
    public List<Integer> addMachine(int machine_id) {
        // Write your code here
        List<Integer> thisShard = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < shardNum; i++) {
            int randomId = r.nextInt(totalNum);
            thisShard.add(randomId);
            map.put(randomId, machine_id);
        }
        return thisShard;
    }

    // @param hashcode an integer
    // @return a machine id
    public int getMachineIdByHashCode(int hashcode) {
        // Write your code here
        int machineId = 0;
        for (int i = hashcode; i < totalNum; i++) {
            if (map.keySet().contains(i)) {
                machineId = map.get(i);
                return machineId;
            }
        }
        return 0;
    }
}
