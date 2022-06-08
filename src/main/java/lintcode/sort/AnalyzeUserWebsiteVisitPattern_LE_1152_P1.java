package lintcode.sort;

import java.util.*;

public class AnalyzeUserWebsiteVisitPattern_LE_1152_P1 {
    /*
        - the description is kinda confusion, but it is fine for me
        - use brute force is straightforward and best for this problem, since
        1. 3 <= username.length <= 50;
        2. It is guaranteed that there is at least one user who visited at least three websites.
        3. All the tuples [username[i], timestamp[i], website[i]] are unique.
        - Time is O(N^3), N - is the size of website one user visits
    */
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        //step 1. build the map of username - pair (time + website), so that Pair info is grouped per username
        Map<String, List<Pair>> map = new HashMap<>();
        for (int i = 0; i < username.length; i++) {
            String curUser = username[i];
            if (!map.containsKey(curUser)) {
                map.put(curUser, new ArrayList<>());
            }
            map.get(curUser).add(new Pair(timestamp[i], website[i]));
        }

        //step 2. build the pattern count map the save the one with max score
        Map<String, Integer> countMap = new HashMap<>(); //pattern, score
        String max = "";
        for (String curUser : map.keySet()) {
            List<Pair> curPairList = map.get(curUser);
            Collections.sort(curPairList, (a, b) -> a.timestamp - b.timestamp);
            Set<String> visited = new HashSet<>();
            for (int i = 0; i < curPairList.size() - 2; i++) {
                for (int j = i + 1; j < curPairList.size() - 1; j++) {
                    for (int k = j + 1; k < curPairList.size(); k++) {
                        String pattern = curPairList.get(i).website + " " + curPairList.get(j).website + " " + curPairList.get(k).website;
                        //to one user, same pattern is counted only once
                        if (visited.contains(pattern)) {
                            continue;
                        }
                        visited.add(pattern);
                        countMap.put(pattern, countMap.getOrDefault(pattern, 0) + 1);

                        //maintain the pattern with max score in the max variable
                        if (max == "" || countMap.get(max) < countMap.get(pattern) || countMap.get(max) == countMap.get(pattern) && pattern.compareTo(max) < 0) {
                            max = pattern;
                        }
                    }
                }
            }

        }

        //step 2. build the result
        List<String> res = new ArrayList<>();
        String[] t = max.split(" ");
        for (String s : t) {
            res.add(s);
        }
        return res;
    }

    class Pair {
        int timestamp;
        String website;

        Pair(int timestamp, String website) {
            this.timestamp = timestamp;
            this.website = website;
        }
    }

    public static void main(String[] args) {
        AnalyzeUserWebsiteVisitPattern_LE_1152_P1 solution = new AnalyzeUserWebsiteVisitPattern_LE_1152_P1();
        String[] username = {"joe","joe","joe","james","james","james","james","mary","mary","mary"};
        int[] timestamp = {1,2,3,4,5,6,7,8,9,10};
        String[] website = {"home","about","career","home","cart","maps","home","home","about","career"};
        //["home","about","career"]

        System.out.println(solution.mostVisitedPattern(username, timestamp, website).toString());
    }
}
