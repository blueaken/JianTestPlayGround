package lintcode.sort;

import java.util.*;

public class AnalyzeUserWebsiteVisitPattern_LE_1152 {
    /*
        - the description is kinda confusion, but it is fine for me
        - use brute force is straightforward and best for this problem
        - Time is O(N^3), N - is the size of website one user visits
    */
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        //step 1 - for each user, count the website and timestamp he visits
        Map<String, List<Pair>> map = new HashMap<>(); //username, time & website Pair he visits
        for (int i = 0; i < username.length; i++) {
            List<Pair> list = new ArrayList<>();
            map.putIfAbsent(username[i], list);
            map.get(username[i]).add(new Pair(timestamp[i], website[i]));
        }

        //step 2 - explore all the possible website 3 sequence and record the largest score
        String max = "";
        Map<String, Integer> count = new HashMap<>();
        for (String u : map.keySet()) {
            List<Pair> curList = map.get(u);
            Collections.sort(curList, (a, b) -> a.time - b.time);
            Set<String> set = new HashSet<>(); //to avoid same pattern more than once for one user
            for (int i = 0; i < curList.size() - 2; i++) {
                for (int j = i + 1; j < curList.size() - 1; j++) {
                    for (int k = j + 1; k < curList.size(); k++) {
                        String curP = curList.get(i).website + " " + curList.get(j).website + " " + curList.get(k).website;
                        if (set.contains(curP)) {
                            break;
                        }
                        set.add(curP);
                        count.put(curP, count.getOrDefault(curP, 0) + 1);

                        if (max == "" || count.get(max) < count.get(curP)
                                || (count.get(max) == count.get(curP) && max.compareTo(curP) > 0)) {
                            max = curP;
                        }
                    }
                }
            }
        }

        //step 3 - build the result
        String[] temp = max.split(" ");
        List<String> res = new ArrayList<>();
        for (String s : temp) {
            res.add(s);
        }
        return res;
    }

    class Pair {
        int time;
        String website;

        Pair(int time, String website) {
            this.time = time;
            this.website = website;
        }
    }

    public static void main(String[] args) {
        AnalyzeUserWebsiteVisitPattern_LE_1152 solution = new AnalyzeUserWebsiteVisitPattern_LE_1152();
        String[] username = {"joe","joe","joe","james","james","james","james","mary","mary","mary"};
        int[] timestamp = {1,2,3,4,5,6,7,8,9,10};
        String[] website = {"home","about","career","home","cart","maps","home","home","about","career"};
        //["home","about","career"]

        System.out.println(solution.mostVisitedPattern(username, timestamp, website).toString());
    }
}
