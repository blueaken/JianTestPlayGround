package lintcode.dfs;

public class NumberOfProvince_LE_547 {
    /*
        - similar to 200. Number of Islands
        - ref 花花 https://www.youtube.com/watch?v=HHiHno66j40
        - Time is O(N^2)
        - Space is O(N), note can also update the input matrix itself to store visited info, but it changes the original input and not recommended
    */
    public int findCircleNum(int[][] isConnected) {
        int ans = 0;
        int n = isConnected.length;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            ans++;
            dfs(isConnected, i, n, visited);
        }
        return ans;
    }

    private void dfs(int[][] isConnected, int curr, int numberOfCities, boolean[] visited) {
        visited[curr] = true;
        //traverse each city
        for (int i = 0; i < numberOfCities; i++) {
            if (!visited[i] && isConnected[curr][i] == 1) {
                dfs(isConnected, i, numberOfCities, visited);
            }
        }
        return;
    }

    public static void main(String[] args) {
        NumberOfProvince_LE_547 solution = new NumberOfProvince_LE_547();
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};//2

        System.out.println(solution.findCircleNum(isConnected));
    }
}
