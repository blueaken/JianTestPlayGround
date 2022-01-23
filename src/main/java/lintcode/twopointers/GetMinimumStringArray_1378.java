package lintcode.twopointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetMinimumStringArray_1378 {
    /**
     * @param tagList: The tag list.
     * @param allTags: All the tags.
     * @return: Return the answer
     */
    //Idea:
    //- Subarray 不是cherry pick，而是一个部分整体
    //- 同向双指针，一个指向当前处理的Tag；另一个指向当前Subarray的起始位置，来计算当前长度和去重
    public int getMinimumStringArray(String[] tagList, String[] allTags) {
        // Write your code here
        if (allTags.length == 0 || tagList.length == 0) {
            return -1;
        }

        List<String> tags = Arrays.asList(tagList);
        Map<String, Integer> map = new HashMap<>();

        int minLen = Integer.MAX_VALUE;
        int curSubStartPos = 0;
        for (int pos = 0; pos < allTags.length; pos++) {
            String curTag = allTags[pos];
            if (tags.contains(curTag)) {
                if (!map.containsKey(curTag)) {
                    map.put(curTag, 1);
                } else {
                    map.put(curTag, map.get(curTag) + 1);
                }
            }

            while (tags.size() == map.keySet().size()) {
                minLen = Math.min(minLen, pos - curSubStartPos + 1);
                if (tags.contains(allTags[curSubStartPos])) {
                    map.put(allTags[curSubStartPos], map.get(allTags[curSubStartPos]) - 1);
                    if (map.get(allTags[curSubStartPos]) == 0) {
                        map.remove(allTags[curSubStartPos]);
                    }
                }
                curSubStartPos++;
            }

        }

        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }

    public static void main(String[] args) {
        String[] tags = {"cawb","sl","ocmhj"};
        String[] allTags = {"cawb","ocmhj","scn","sl","cawb","ocmhj"};

        GetMinimumStringArray_1378 solution = new GetMinimumStringArray_1378();
        System.out.println(solution.getMinimumStringArray(tags, allTags));
    }
}
