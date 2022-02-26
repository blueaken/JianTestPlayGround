package lintcode.dailycheckin;

import java.util.*;

public class FriendshipService_560 {
    private Map<Integer, List<Integer>> toFromRelMap;
    private Map<Integer, List<Integer>> fromToRelMap;

    public FriendshipService_560() {
        // do intialization if necessary
        this.toFromRelMap = new HashMap<Integer, List<Integer>>();
        this.fromToRelMap = new HashMap<Integer, List<Integer>>();
    }

    /*
     * @param user_id: An integer
     * @return: all followers and sort by user_id
     */
    public List<Integer> getFollowers(int user_id) {
        // write your code here
        return toFromRelMap.getOrDefault(user_id, new ArrayList<Integer>());
    }

    /*
     * @param user_id: An integer
     * @return: all followings and sort by user_id
     */
    public List<Integer> getFollowings(int user_id) {
        // write your code here
        return fromToRelMap.getOrDefault(user_id, new ArrayList<Integer>());
    }

    /*
     * @param from_user_id: An integer
     * @param to_user_id: An integer
     * @return: nothing
     */
    public void follow(int to_user_id, int from_user_id) {
        // write your code here
        List<Integer> cur = toFromRelMap.getOrDefault(to_user_id, new ArrayList<Integer>());
        if (!cur.contains(from_user_id)) {
            cur.add(from_user_id);
        }
        Collections.sort(cur);
        toFromRelMap.put(to_user_id, cur);

        cur = fromToRelMap.getOrDefault(from_user_id, new ArrayList<Integer>());
        if (!cur.contains(to_user_id)) {
            cur.add(to_user_id);
        }
        Collections.sort(cur);
        fromToRelMap.put(from_user_id, cur);
    }

    /*
     * @param from_user_id: An integer
     * @param to_user_id: An integer
     * @return: nothing
     */
    public void unfollow(int to_user_id, int from_user_id) {
        // write your code here
        List<Integer> cur = toFromRelMap.getOrDefault(to_user_id, new ArrayList<Integer>());
        if (cur.contains(from_user_id)) {
            cur.remove(Integer.valueOf(from_user_id));
        }
        toFromRelMap.put(to_user_id, cur);

        cur = fromToRelMap.getOrDefault(from_user_id, new ArrayList<Integer>());
        if (cur.contains(to_user_id)) {
            cur.remove(Integer.valueOf(to_user_id));
        }
        fromToRelMap.put(from_user_id, cur);
    }

    public static void main(String[] args) {
        FriendshipService_560 solution = new FriendshipService_560();
        solution.follow(1, 3);
        solution.getFollowers(1);
        solution.getFollowings(3);
        solution.follow(2, 3);
        solution.getFollowings(3);
        solution.unfollow(1, 3);
        solution.getFollowings(3);

    }
}
