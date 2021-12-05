package lintcode.colleciton.selected.phase3_array;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzz_9 {
    /**
     * @param n: An integer
     * @return: A list of strings.
     * 更多后面细节分析参考：https://blog.51cto.com/u_15127595/2729364
     */
    public List<String> fizzBuzz(int n) {
        // write your code here

        //挑战用1行写 - 只是花哨一点，对性能没有任何影响，并且可读性变差，just FYI
        //return IntStream.range(1, n + 1).mapToObj(a -> a % 15 == 0 ? "fizz buzz" : a % 3 == 0 ? "fizz" : a % 5 == 0 ? "buzz" : String.valueOf(a)).collect(Collectors.toList());

        List<String> result = new ArrayList<>();
        /*
         * - 挑战只用一个if，使用预先设置数据
         */
        for (int i = 1; i <= n; i++) {
            result.add(String.valueOf(i));
        }

        for (int i = 3; i <= n; i = i + 3) {
            result.set(i-1, "fizz");
        }

        for (int i = 5; i <= n; i = i + 5) {
            if (i % 3 == 0) {
                result.set(i-1, "fizz buzz");
            } else {
                result.set(i-1, "buzz");
            }
        }

        /*
         * - 挑战只用一个if，使用helper判断
         */
        // for (int i = 1; i <= n; i++) {
        //     String word = helper(i, 3, "fizz") + helper(i, 15, " ") + helper(i, 5, "buzz");
        //     if (word.equals("   ")) {
        //         result.add(String.valueOf(i));
        //     } else {
        //         result.add(word.trim());
        //     }
        // }

        return result;

        /*
         * normal solution
         */
        // List<String> result = new ArrayList<>();
        // for (int i = 1; i <= n; i++) {
        //     if (i % 3 == 0 && i % 5 == 0) {
        //         result.add("fizz buzz");
        //     } else if (i % 3 == 0) {
        //         result.add("fizz");
        //     } else if (i % 5 == 0) {
        //         result.add("buzz");
        //     } else {
        //         result.add(String.valueOf(i));
        //     }
        // }
        // return result;
    }

    private String helper(int i, int div, String ret) {
        return (i % div == 0 ? ret : " ");
    }
}
