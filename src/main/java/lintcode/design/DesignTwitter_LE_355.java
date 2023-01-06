package lintcode.design;

import java.util.*;

public class DesignTwitter_LE_355 {
    /**
     1.6.2023
     OOD problem - try ref 东哥 post, but without the static class, which is not necessary
     */

    private static int timestamp = 0;

    // 之所以要把 Tweet 和 User 类放到 Twitter 类里面，是因为 Tweet 类必须要用到一个全局时间戳 timestamp，而 User 类又需要用到 Tweet 类记录用户发送的推文，所以它们都作为内部类。
    class Tweet {
        // Tweet实例需要记录自己的 tweetId 和发表时间 time，而且作为链表节点，要有一个指向下一个节点的 next 指针。
        int id;
        int time;
        Tweet next;

        Tweet (int id, int time) {
            this.id = id;
            this.time = time;
            this.next = null;
        }

    }
    class User {
        // User实例需要存储的信息有 userId，关注列表，以及该用户发过的推文列表。其中关注列表应该用集合（Hash Set）这种数据结构来存，因为不能重复，而且需要快速查找；推文列表应该由链表这种数据结构储存。

        int id;
        Set<Integer> followed;
        Tweet head;

        User (int id) {
            this.id = id;
            followed = new HashSet<>();
            head = null;
            //默认关注下自己
            followed.add(id);
        }

        // 除此之外，根据面向对象的设计原则，「关注」「取关」和「发文」应该是 User 的行为，况且关注列表和推文列表也存储在 User 类中，所以我们也应该给 User 添加 follow，unfollow 和 post 这几个方法。

        public void follow (int userId) {
            followed.add(userId);
        }

        public void unfollow (int userId) {
            if (userId != this.id) {
                followed.remove(userId);
            }
        }

        public void post (int tweetId) {
            Tweet twt = new Tweet(tweetId, timestamp);
            timestamp++;

            // 将新发布的Tweet放在推文链表头部
            twt.next = head;
            head = twt;
        }

    }

    // 保存 userId 和 user关系
    private Map<Integer, User> userMap = new HashMap<>();

    public DesignTwitter_LE_355() {

    }

    // user发表一条tweet
    public void postTweet(int userId, int tweetId) {
        // 如果不存在就新建一个user实例
        if (!userMap.containsKey(userId)) {
            userMap.put(userId, new User(userId));
        }
        User user = userMap.get(userId);
        user.post(tweetId);
    }

    // follower 关注 followee
    public void follow(int followerId, int followeeId) {
        // 如果不存在就新建user实例
        if (!userMap.containsKey(followerId)) {
            userMap.put(followerId, new User(followerId));
        }
        User follower = userMap.get(followerId);

        if (!userMap.containsKey(followeeId)) {
            userMap.put(followeeId, new User(followeeId));
        }
        // User followee = userMap.get(followeeId);

        follower.follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (userMap.containsKey(followerId)) {
            User follower = userMap.get(followerId);
            follower.unfollow(followeeId);
        }
    }

    /** 返回该 user 关注的人（包括他自己）最近的动态 id，最多 10 条，而且这些动态必须按从新到旧的时间线顺序排列。*/
    public List<Integer> getNewsFeed(int userId) {
        //参考实现合并 k 个有序链表的算法，用PriorityQueue辅助
        List<Integer> res = new ArrayList<>();
        if (!userMap.containsKey(userId)) {
            return res;
        }

        Set<Integer> users = userMap.get(userId).followed;
        // 按照Tweet的时间排序
        PriorityQueue<Tweet> heap = new PriorityQueue<>((a, b) -> b.time - a.time);
        for (int id : users) {
            Tweet twt = userMap.get(id).head;
            if (twt == null) {
                continue;
            }
            heap.offer(twt);
        }

        // 开始合并 k 个有序链表的算法
        while (heap.size() > 0) {
            if (res.size() == 10) {
                break;
            }

            Tweet cur = heap.poll();
            res.add(cur.id);

            if (cur.next != null) {
                heap.offer(cur.next);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        DesignTwitter_LE_355 solution = new DesignTwitter_LE_355();
        solution.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
        System.out.println(solution.getNewsFeed(1));  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
        solution.follow(1, 2);    // User 1 follows user 2.
        solution.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
        System.out.println(solution.getNewsFeed(1));  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        solution.unfollow(1, 2);  // User 1 unfollows user 2.
        System.out.println(solution.getNewsFeed(1));// User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.
    }
}
