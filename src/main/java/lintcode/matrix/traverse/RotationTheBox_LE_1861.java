package lintcode.matrix.traverse;

public class RotationTheBox_LE_1861 {
    /**
     12.19.23
     ref https://leetcode.com/problems/rotating-the-box/solutions/3664550/never-before-ever-after-intution-approach-tc-sc/
     */
    public char[][] rotateTheBox(char[][] box) {
        int row = box.length, col = box[0].length;
        char[][] ans = new char[col][row];

        // rotate the box first
        int l = row-1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ans[j][l] = box[i][j];
            }
            l--;
        }

        // process stone position after rotation, start from botton to top for each column
        int newRow = col, newCol = row;
        for (int j = 0; j < newCol; j++) {

            int i = newRow-1;
            int k = newRow-1;

            while (i >= 0 && k >= 0) {
                if (ans[i][j] == '*') {
                    k = i-1;
                } else if (ans[i][j] == '#') {
                    ans[i][j] = '.';
                    ans[k][j] = '#';
                    k--;
                }
                i--;
            }
        }
        return ans;
    }
}
