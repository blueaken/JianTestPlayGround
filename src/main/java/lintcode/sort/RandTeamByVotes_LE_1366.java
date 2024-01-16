package lintcode.sort;

import java.util.Arrays;

public class RankTeamByVotes_LE_1366 {
    /**
        1.16.24
        - follow the solution link
     */
    public String rankTeams(String[] votes) {
        int n = votes.length;
        int len = votes[0].length();

        int[][] rank = new int[26][len+1];
        // add an extra column indicate the index of the character
        for (int i = 0; i < 26; i++) {
            rank[i][len] = i;
        }

        for (int i = 0; i < n; i++) {
            String cur = votes[i];
            for (int j = 0; j < len; j++) {
                int c = cur.charAt(j) - 'A';
                rank[c][j]++;
            }
        }

        //sort in descending order
        Arrays.sort(rank, (a, b) -> {
            //compare each position from start to end
            for (int i = 0; i < len; i++) {
                if (a[i] > b[i]) {
                    return -1;
                }
                if (a[i] < b[i]) {
                    return 1;
                }
            }
            return 0;
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append((char)('A' + rank[i][len]));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        RankTeamByVotes_LE_1366 solution = new RankTeamByVotes_LE_1366();
        String[] votes = {"ABC","ACB","ABC","ACB","ACB"};
        System.out.println(solution.rankTeams(votes));
    }
}
