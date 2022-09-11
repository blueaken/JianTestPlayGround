package lintcode.matrix;

public class CyclicallyRotatingGrid_LE_1914 {
    /*
        ref discussion - https://leetcode.com/problems/cyclically-rotating-a-grid/discuss/2005621/My-Java-solution%3A-4ms-beats-85-verbose-but-logic-is-clean
        - like his comment: code is read more than written, let's keep it simple and easier to pick up by teammates than fancy but hard to understand style
        - a few small tasks:
          1. denote the grid and each layter by 4 parameters: left, right, top, bottom
          2. store elements of each layer into an array
          3. define a method to rotate each layer and recusively to next layer
          4. define a method to find next position of the rotation called by the method above
         Note: k can be more the element length of the layer, need to get the real k before each rotation

    */
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        rotateInternal(grid, 0, n - 1, 0, m - 1, k);
        return grid;
    }

    private void rotateInternal(int[][] grid, int left, int right, int top, int bottom, int k) {
        if (left > right || top > bottom) {
            return;
        }
        int layerLen = (right - left + 1) * 2 + (bottom - top + 1) * 2 - 4;
        int realK = k % layerLen;
        if (realK > 0) {
            rotateLayer(grid, left, right, top, bottom, realK);
        }
        //note should always use the original k, otherwise realK changes when layer length varies
        rotateInternal(grid, left + 1, right - 1, top + 1, bottom - 1, k);
        return;
    }

    private void rotateLayer(int[][] grid, int left, int right, int top, int bottom, int k) {
        int layerLen = (right - left + 1) * 2 + (bottom - top + 1) * 2 - 4;
        int[] arr = new int[layerLen];
        int[] curPos = {top, left};
        int[] rotateStartPos = null;

        //load elements of each layer to array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = grid[curPos[0]][curPos[1]];
            if (i == k) {
                rotateStartPos = curPos;
            }
            curPos = findNextPos(grid, left, right, top, bottom, curPos);
        }

        //rotate
        curPos = rotateStartPos;
        for (int i = 0; i < arr.length; i++) {
            grid[curPos[0]][curPos[1]] = arr[i];
            curPos = findNextPos(grid, left, right, top, bottom, curPos);
        }
        return;
    }

    private int[] findNextPos(int[][] grid, int left, int right, int top, int bottom, int[] curPos) {
        int x = curPos[0];
        int y = curPos[1];

        if (x == top && y > left) { //top edge
            return new int[] {x, y - 1};
        } else if (y == left && x < bottom) { //left edge
            return new int[] {x + 1, y};
        } else if (x == bottom && y < right) { //bottom edge
            return new int[] {x, y + 1};
        } else { //right edge
            return new int[] {x - 1, y};
        }
    }
}
