package lintcode.math.power;

public class SuperPow_LE_372 {
    /**
     1.18.2023
     ref 东哥 post, 可以进一步对myPos方法中k的奇偶数分情况优化，但目前这个解法可以AC
     */
    int base = 1337;

    public int superPow(int a, int[] b) {
        int n = b.length;
        if (n == 0) {
            return 1;
        }

        int[] b1 = new int[n-1];
        for (int i = 0; i < b1.length; i++) {
            b1[i] = b[i];
        }

        int part1 = myPow(superPow(a, b1), 10);
        int part2 = myPow(a, b[n-1]);

        // 每次乘法都要求模
        return (part1 * part2) % base;
    }

    // 计算a的k次方然后求模
    private int myPow(int a, int k) {
        a %= base;

        int res = 1;
        for (int i = 0; i < k; i++) {
            res *= a;
            // 每次乘法都要求模
            res %= base;
        }
        return res;
    }
}
