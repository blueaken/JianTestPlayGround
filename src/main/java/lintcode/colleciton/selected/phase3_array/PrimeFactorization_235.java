package lintcode.colleciton.selected.phase3_array;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorization_235 {
    /**
     * @param num: An integer
     * @return: an integer array
     */
    public static List<Integer> primeFactorization(int num) {
        // write your code here
        // 算法流程：
        // 1. up一般设定为sqrt(num)，因为一个数大于其根号的质因数最多只有一个，那么遍历其根号内的数可以将时间复杂度减小至根号n，若遍历完prime后该数不为1，则其值为最后一个质因数
        // 2. 从小到大遍历[2,up]，若num能够被i整除则循环除以i直到不能被整除，每次除以i都向答案值数组增加一个i，因为是从小到大遍历，则必定只有质数能被取为因数
        // Ref: https://www.jiuzhang.com/solution/prime-factorization/
        List<Integer> result = new ArrayList<>();
        for (int i = 2; i * i <= num; i++) {
            while (num % i == 0) {
                result.add(i);
                num /= i;
            }
        }
        if (num > 1) {
            result.add(num);
        }
        return result;
    }

    public static void main(String[] args) {
//        int input = 10;
//        int input = 99;
        int input = 25;
        System.out.println(primeFactorization(input).toString());
    }
}
