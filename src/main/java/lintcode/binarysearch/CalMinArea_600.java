package lintcode.binarysearch;

public class CalMinArea_600 {
    /**
     * @param image: a binary matrix with '0' and '1'
     * @param x: the location of one of the black pixels
     * @param y: the location of one of the black pixels
     * @return: an integer
     */
    //Idea: 分别BS计算上下左右的index，计算出矩形面积。Ref - https://www.lintcode.com/problem/600/solution/17206
    //and：为了计算右边的边界，只能使用了九章模板
    public int minArea(char[][] image, int x, int y) {
        // write your code here
        if (image.length == 0 || image[0].length == 0) {
            return -1;
        }

        int n = image.length;
        int m = image[0].length;

        int left = findLeft(image, 0, y);
        int right = findRight(image, y, m - 1);
        int top = findTop(image, 0, x);
        int bottom = findBottom(image, x, n - 1);

        return (right - left + 1) * (bottom - top + 1);
    }

    private int findLeft (char[][] image, int left, int right) {
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (isEmptyColumn(image, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (isEmptyColumn(image, left)) {
            return right;
        }

        return left;
    }

    private int findRight (char[][] image, int left, int right) {
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (isEmptyColumn(image, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (isEmptyColumn(image, right)) {
            return left;
        }

        return right;
    }

    private int findTop (char[][] image, int left, int right) {
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (isEmptyRow(image, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (isEmptyRow(image, left)) {
            return right;
        }

        return left;
    }

    private int findBottom (char[][] image, int left, int right) {
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (isEmptyRow(image, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (isEmptyRow(image, right)) {
            return left;
        }

        return right;
    }

    private boolean isEmptyColumn (char[][] image, int colIndex) {
        int n = image.length;
        for (int i = 0; i < n; i++) {
            if (image[i][colIndex] == '1') {
                return false;
            }
        }
        return true;
    }

    private boolean isEmptyRow (char[][] image, int rowIndex) {
        int m = image[0].length;
        for (int i = 0; i < m; i++) {
            if (image[rowIndex][i] == '1') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] image = new char[][]{{'0','0','1','0'},{'0','1','1','0'},{'0','1','0','0'}};
        int x = 0;
        int y = 2;

        CalMinArea_600 solution = new CalMinArea_600();
        System.out.println(solution.minArea(image, x, y));
    }
}
