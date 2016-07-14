package leetcode.algorithm.medium.twosum3;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jshe18 on 8/8/15.
 */
public class Solution_HashMap {
    private Map<Integer, Integer> map = new HashMap<>();

    public Map<Integer, Integer> getMap() {
        return map;
    }

    public void setMap(Map<Integer, Integer> map) {
        this.map = map;
    }

    public void add(int value){
        int count = map.containsKey(value) ? map.get(value) : 0;
        map.put(value, count+1);
    }

    public boolean find(int target){
        if (map.size()>0){
            for (int i: map.keySet()){
                if (i == (target-i)){
                    return (map.get(i)>=2); //ensure there are at least 2 for duplicates
                }
                if (map.containsKey(target-i)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        Map<Integer, Integer> map = new HashMap<>();
        Solution_HashMap solution_hashMap = new Solution_HashMap();
        solution_hashMap.setMap(map);

        solution_hashMap.add(1);
        solution_hashMap.add(3);
        solution_hashMap.add(5);

        System.out.println(solution_hashMap.find(4));
//        System.out.println(solution_hashMap.find(7));
    }

}
