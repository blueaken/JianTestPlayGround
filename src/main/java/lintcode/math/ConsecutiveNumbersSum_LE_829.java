package lintcode.math;

public class ConsecutiveNumbersSum_LE_829 {
    /*
        ref - https://www.youtube.com/watch?v=JZsI8NxEdN8
        - not a hard one if you know the math formula
        - since have to be consecutive number, so it is a 等差数列求和公式 - (首项 + 末项) * 项数 / 2
        - 设有m项，和为n, 因为是consecutive number, 差值为1
        - 首项为x, 末项为 x + m - 1, n = (x + x + m - 1) * m / 2
        - n已知情况下，扫描x或者m中一个，只要当另一个为正整数则为一个解；
        - 如果扫描x,需要开根号解m不方便；因此扫描m，上面等式转换为 x = (m + 2*n - m^2) / (2*m)
        - x = (2*n - m^2) / 2*m + 0.5; x需要>0, 2*n - m^2 > 0, m < sqrt(2*n)
    */
    public int consecutiveNumbersSum(int n) {
        int ans = 0;
        for (int m = 1; m < Math.sqrt(2*n); m++) {
            if ((m + 2*n - m*m) % (2*m) == 0) {
                ans++;
            }
        }
        return ans;
    }
}
