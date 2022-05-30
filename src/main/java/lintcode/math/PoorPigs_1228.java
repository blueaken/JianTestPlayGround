package lintcode.math;

public class PoorPigs_1228 {
    /**
     * @param buckets: an integer
     * @param minutesToDie: an integer
     * @param minutesToTest: an integer
     * @return: how many pigs you need to figure out the "poison" bucket within p minutes
     */
    //Idea: 用到信息论知识，一头猪可以测试4次，反应5种状态（0-15 min死 。。。45-60分钟死 + 都不死），可以测试的桶数就是：状态数^小猪数量；
    //      所需要的小猪数量就是 Log 状态数量（下标）桶数量，Ref: https://blog.csdn.net/qq_31027515/article/details/90552507
    //      本题如果不懂信息论海明码理论的话，还是蛮难的，不是easy
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        // Write your code here
        int pig = 0;
        int state = minutesToTest / minutesToDie + 1;
        while ( Math.pow(state, pig) < buckets ) {
            pig++;
        }
        return pig;
    }

    public static void main(String[] args) {
        int buckets = 1000;
        int minutesToDie = 15;
        int minutesToTest = 60;

        PoorPigs_1228 solution = new PoorPigs_1228();
        System.out.println(solution.poorPigs(buckets, minutesToDie, minutesToTest));
    }
}
