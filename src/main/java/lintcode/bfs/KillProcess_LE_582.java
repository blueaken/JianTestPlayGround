package lintcode.bfs;

import java.util.*;

public class KillProcess_LE_582 {
    /*
        - gut feeling is bfs with queue, Time is O(N^N), but TLE
        - ref the solution link, like the approach 4, there is no need to build a tree, but with the help of a map, also can also bfs in O(N) time, space is also O(N)
    */
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        //build relationship map, in O(N) time
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++) {
            List<Integer> list = map.getOrDefault(ppid.get(i), new ArrayList<>());
            list.add(pid.get(i));
            map.put(ppid.get(i), new ArrayList<>(list));
        }

        //bfs - O(N)
        List<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(kill);
        while (queue.size() > 0) {
            int cur = queue.poll();
            res.add(cur);
            if (map.containsKey(cur)) {
                queue.addAll(map.get(cur));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        KillProcess_LE_582 solution = new KillProcess_LE_582();
//        List<Integer> pid = new ArrayList<>();
//        pid.add(1);
//        pid.add(3);
//        pid.add(10);
//        pid.add(5);
//
//        List<Integer> ppid = new ArrayList<>();
//        ppid.add(3);
//        ppid.add(0);
//        ppid.add(5);
//        ppid.add(3);
//
//        int kill = 5;
//        //[5, 10]

        List<Integer> pid = new ArrayList<>();
        pid.add(1);
        pid.add(2);
        pid.add(3);

        List<Integer> ppid = new ArrayList<>();
        ppid.add(0);
        ppid.add(1);
        ppid.add(2);

        int kill = 1;
        //[1, 2, 3]

        System.out.println(solution.killProcess(pid, ppid, kill));
    }
}
