package lintcode.dynamicprogramming2.maxsubarray;

import java.util.HashSet;
import java.util.Set;

public class SubstringWithLargestVariance_LE_2272_P3 {
    /*
        P1 - still feel abstract
        - read Huifeng Guan video - https://www.youtube.com/watch?v=P6KnO-Dw0Fo
        - he refactor the solution to a better one, had to read the new video above and cheked the github link
        - Time - O(256*N)
        Following is his note:
        =================================================
        我们依然按照kadane算法的思路，但是设置两个临时变量：curSum0表示以当前元素为结尾、不包含-1的最大subarray sum，另外用curSum1表示以当前元素为结尾、已经包含-1的最大subarray sum。转移方程如下：

  for (int i = 0; i < n; i++)
  {
      if (nums[i] == 1)
      {
          curSum1 = curSum1+nums[i];
          curSum0 = max(curSum0+nums[i], nums[i]);
      }
      else if (nums[i] == -1)
      {
          curSum1 = max(nums[i], max(curSum0, curSum1)+nums[i]);  // 三种情况可以转移到新的curSum1
          curSum0 = 0;  // 因为nums[i]是-1，curSum0没有意义，只能置零
      }

      ret = max(ret, curSum1);
  }
特别注意，curSum0的初始值可以是0，但是curSum1的初始值必须设置为INT_MIN.
        =================================================
        P2 10.13.2022
        ref prev notes
        =================================================
        P3 10.28.2022
        ref prev notes
        =================================================
    */
    public int largestVariance(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }

        int ans = 0;
        for (char a : set) {
            for (char b : set) {
                if (a == b) {
                    continue;
                }

                int curSum0 = 0; //cur maxsum without -1
                int curSum1 = Integer.MIN_VALUE; //cur maxsum including -1
                for (int i = 0; i < s.length(); i++) {
                    int cur = s.charAt(i);
                    if (cur == a) {
                        curSum0 += 1;
                        curSum1 += 1;
                    } else if (cur == b) {
                        curSum1 = Math.max(curSum0, curSum1)-1;
                        curSum0 = 0;
                    }
                    ans = Math.max(ans, curSum1);
                }
            }
        }
        return ans;
    }
}
