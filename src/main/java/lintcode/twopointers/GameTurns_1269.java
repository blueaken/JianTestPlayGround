package lintcode.twopointers;

import java.util.*;

public class GameTurns_1269 {
    /**
     * @param to: The target of everyone will throw the handkerchief to.
     * @return: Return the number of turns the game will stop.
     */
    //Idea: 模拟同时进行这个游戏，注意每一轮保留每人手绢是否改变的纪录来确保玩的是上一轮留下来的手绢
    //问题：如一轮中多个人都给同一个人，这轮这个人最后应该是持有1个手绢还是多个手绢。如果是多个手绢的话，每人都需要一个List来保持纪录，空间和复杂度很高。
    //尝试一个一个模拟；
    //Ref: https://www.lintcode.com/problem/1269/solution/32771
    public int gameTurns(List<Integer> to) {
        int minCount = Integer.MAX_VALUE;

        for (int i = 0; i < to.size(); i++) {
            int count = 0;
            Set<Integer> visited = new HashSet<>();
            int toPos = to.get(i);

            count++;
            while (toPos != i) {
                toPos = to.get(toPos);
                count++;
                // 如果到了已访问过的点，代表这个手绢进入死循环，到不了出发点
                if (visited.contains(toPos)) {
                    break;
                }
                visited.add(toPos);
            }
            // 只有回到出发点，才算做有效值
            if (toPos == i) {
                minCount = Math.min(minCount, count);
            }
        }

        return minCount;
    }


//    public int gameTurns(List<Integer> to) {
//        // write your code here,
//        if (to == null) {
//            return -1;
//        }
//
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < to.size(); i++) {
//            //i, i mapping to position num, hk num, initially they are the same
//            map.put(i, i);
//        }
//
//        int count = 0;
//        while (count < to.size()) {
//            count++;
//            //start the game
//            boolean[] isChanged = new boolean[to.size()];
//            Map<Integer, Integer> beforeGameMap = new HashMap<>(map);
//            for (int i = 0; i < to.size(); i++) {
//                int toPos = to.get(i);
//                if (!isChanged[i]) {
//                    map.put(toPos, map.get(i));
//                } else {
//                    map.put(toPos, beforeGameMap.get(i));
//                }
//                isChanged[toPos] = true;
//            }
//            //check the result
//            for (int i = 0; i < to.size(); i++) {
//                if (i == map.get(i) && isChanged[i]) {
//                    return count;
//                }
//            }
//        }
//        return count;
//    }

    public static void main(String[] args) {
        ArrayList<Integer> to = new ArrayList<>(
                Arrays.asList(new Integer[] {1, 2, 0, 4, 3, 0})
        );

//        ArrayList<Integer> to = new ArrayList<>(
//                Arrays.asList(new Integer[] {12,12,4,10,7,1,13,12,7,10,0,9,0,8,12})
//        );

        GameTurns_1269 solution = new GameTurns_1269();
        System.out.println(solution.gameTurns(to));
    }
}
