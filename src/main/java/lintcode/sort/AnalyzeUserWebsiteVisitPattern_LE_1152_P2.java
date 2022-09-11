package lintcode.sort;

import java.util.*;

public class AnalyzeUserWebsiteVisitPattern_LE_1152_P2 {
    /*
        - Brute Force search is the only way
        - P2
    */
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Visit>> map = new HashMap<>(); //username, visit
        Map<String, Integer> count = new HashMap<>(); //pattern, score

        //1. build username and visits map
        for (int i = 0; i < username.length; i++) {
            String u = username[i];
            List<Visit> visits = map.getOrDefault(u, new ArrayList<>());
            visits.add(new Visit(timestamp[i], website[i]));
            map.put(u, visits);
        }

        //2. brute force search on each pattern per username
        String maxPattern = "";
        for (String curUser : map.keySet()) {
            List<Visit> curVisits = map.get(curUser);
            Collections.sort(curVisits, (a, b) -> a.timestamp - b.timestamp);
            int n = curVisits.size();
            Set<String> patterns = new HashSet<>();
            for (int i = 0; i < n - 2; i++) {
                for (int j = i + 1; j < n - 1; j++) {
                    for (int k = j + 1; k < n; k++) {
                        String p = curVisits.get(i).website + " " + curVisits.get(j).website + " " + curVisits.get(k).website;
                        if (patterns.contains(p)) {
                            continue;
                        }
                        patterns.add(p);
                        count.put(p, count.getOrDefault(p, 0) + 1);

                        if (maxPattern == "" || count.get(maxPattern) < count.get(p) || (count.get(maxPattern) == count.get(p) && p.compareTo(maxPattern) < 0)) {
                            maxPattern = p;
                        }
                    }
                }
            }
        }

        //3. output the result
        String[] temp = maxPattern.split(" ");
        List<String> res = new ArrayList<>();
        for (String s : temp) {
            res.add(s);
        }
        return res;
    }

    class Visit {
        int timestamp;
        String website;

        Visit (int timestamp, String website) {
            this.timestamp = timestamp;
            this.website = website;
        }
    }

    public static void main(String[] args) {
        AnalyzeUserWebsiteVisitPattern_LE_1152_P2 solution = new AnalyzeUserWebsiteVisitPattern_LE_1152_P2();
        String[] usernames = {"joe","joe","joe","james","james","james","james","mary","mary","mary"};
        int[] timestamps = {1,2,3,4,5,6,7,8,9,10};
        String[] websites = {"home","about","career","home","cart","maps","home","home","about","career"};
        //["home","about","career"]

        System.out.println(solution.mostVisitedPattern(usernames, timestamps, websites));
    }
}
