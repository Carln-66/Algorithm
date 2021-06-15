package dynamic;

/**
 * @Auther: Carl
 * @Date: 2021/06/15/6:28
 * @Description: 最长公共子序列
 */
public class LeetCode_1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int x  = text1.length();
        int y = text2.length();
        int[][] dp = new int[x + 1][y + 1];
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[x][y];
    }
}
