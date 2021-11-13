public class Solution {
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i < dp.length; i++) {
            for (int j = 1; j < i - 2; j++) {
                dp[i] = Math.max(dp[i], Math.max(i - j, dp[i - j]) * j);
            }
        }
        return dp[n];
    }
}
