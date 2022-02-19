package lintcode.binarySearch;

public class CopyBooks_437 {
    /**
     * @param pages: an array of integers
     * @param k: An integer
     * @return: an integer
     */
    //Idea - ref:https://blog.csdn.net/qq_46105170/article/details/104852117
    //1. 所有书都给一个人抄耗时最长，耗时为数组所有数之和；另外每本书都派一个人抄的情况下耗时最短，耗时为数组最大值,
    //   由此我们就有了二分答案的区间
    //2. 在判断在中间时间mid内，能否由k个人完成复印工作。如果可以的话，取左区间寻找更小时间；不行的话，取右空间。
    public int copyBooks(int[] pages, int k) {
        // write your code here
        if (pages == null || pages.length == 0) {
            return 0;
        }

        int start = 0, end = 0;
        for (int i = 0; i < pages.length; i++) {
            start = Math.max(start, pages[i]);
            end += pages[i];
        }

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (isWorkable(pages, mid, k)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private boolean isWorkable (int[] pages, int time, int k) {
        int sumTime = 0;
        int copier = 1;
        for (int i = 0; i < pages.length; i++) {
            if ((sumTime + pages[i]) > time) {
                sumTime = 0; //工作量清零，给下一个人；
                copier++;
            }
            sumTime += pages[i];
        }
        return copier <= k;
    }
}
