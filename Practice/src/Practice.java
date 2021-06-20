public class Practice {
    public int minDistance(String word1, String word2) {
        int x = word1.length();
        int y = word2.length();
        if (x * y == 0) {
            return x + y;
        }
        int[][] dp = new int[x + 1][y + 1];
        for (int i = 0; i < x + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < y + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < x + 1; i++) {
            for (int j = 1; j < y + 1; j++) {
                int left = dp[i - 1][j] + 1;
                int down = dp[i][j - 1] + 1;
                int left_down = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(i - 1)) {
                    left_down += 1;
                }
                dp[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }
        return dp[x][y];
    }
}
