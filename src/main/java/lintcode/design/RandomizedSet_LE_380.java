package lintcode.design;

import java.util.*;

/*
    Ref - https://leetcode.com/problems/insert-delete-getrandom-o1/solution/
    - The Tricky here is to make all operations O(1);
    - A HashMap( or HashSet) has O(1) insert Or remove, but not getRandom;
    - A ArrayList has O(1) insert Or getRandom, but remove takes O(N)
    - The solution is to using both, HashMap to store the index of each Value in the List and When Remove, exchange the last element and pop the last one, which is O(1)

*/
public class RandomizedSet_LE_380 {

    Map<Integer, Integer> map;
    List<Integer> list;

    public RandomizedSet_LE_380() {
        map = new HashMap<>();
        list = new ArrayList();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }

        int idx = list.size();
        map.put(val, idx);
        list.add(idx, val);

        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int lastIdx = list.size() - 1;
        int lastElement = list.get(lastIdx);
        int idx = map.get(val);
        list.set(idx, lastElement);
        map.put(lastElement, idx);

        list.remove(lastIdx);
        map.remove(val);

        return true;
    }

    public int getRandom() {
        Random rand = new Random();

        return list.get(rand.nextInt(list.size()));
    }

    public static void main(String[] args) {
        RandomizedSet_LE_380 solution = new RandomizedSet_LE_380();
        System.out.println(solution.insert(0));
        System.out.println(solution.insert(1));
        System.out.println(solution.remove(0));
        System.out.println(solution.insert(2));
        System.out.println(solution.remove(1));
        System.out.println(solution.getRandom());

        //input:
        //["RandomizedSet","insert","insert","remove","insert","remove","getRandom"]
        //[[],[0],[1],[0],[2],[1],[]]
        //expected - [null,true,true,true,true,true,2]
    }
}