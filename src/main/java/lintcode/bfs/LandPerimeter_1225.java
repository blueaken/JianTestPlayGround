package lintcode.bfs;

public class LandPerimeter_1225 {
    /**
     * @param grid: a 2D array
     * @return: the perimeter of the island
     */
    //Idea: https://www.lintcode.com/problem/1225/solution/18733
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    public int islandPerimeter(int[][] grid) {
        // Write your code here
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //detect 4 directions of land element
                if (grid[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        if (isValid(i + dx[k], j + dy[k], grid)) {
                            perimeter++;
                        }
                    }
                }
            }
        }
        return perimeter;
    }

    private boolean isValid (int x, int y, int[][] grid) {
        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
            return grid[x][y] == 0;
        }
        //if the land element is on the border, then count perimeter
        return true;
    }

    public static void main(String[] args) {
//        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        int[][] grid = {{1,1}};

        LandPerimeter_1225 solution = new LandPerimeter_1225();
        System.out.println(solution.islandPerimeter(grid));
    }
}
