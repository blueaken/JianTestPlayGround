package realworld.nike.minimalnumberofcoins;

/**
 * Author: blueaken
 * Date: 11/22/15 9:36 AM
 */
public class Solution {
    public static int getMinCoinsNum (int sum, int[] coins){
        int[] minCoins = new int[sum + 1];
        for (int s = 1; s <= sum; s++) {
            minCoins[s] = Integer.MAX_VALUE - 1;
        }

        for (int s = 1; s <= sum; s++) {
            for (int coin : coins) {
                if (s >= coin) {
                    minCoins[s] = Math.min(minCoins[s], minCoins[s - coin] + 1);
                }
            }
        }
        return minCoins[sum];
    }

    public static void main(String[] args){
        int testValue1 = 15;
        int[] testCoins1 = {1,3,9,10};
        int expected1 = 3;

        int actualResult1 = getMinCoinsNum(testValue1, testCoins1);

        System.out.println("The test result is: " + (actualResult1 == expected1));
    }
}
