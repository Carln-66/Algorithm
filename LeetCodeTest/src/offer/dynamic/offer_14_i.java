package offer.dynamic;

/**
 * @Auther: Carl
 * @Date: 2021/07/03/18:56
 * @Description: 剪绳子
 */
public class offer_14_i {
    //利用动态规划解决
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i - 2; j++) {
                dp[i] = Math.max(Math.max(dp[i - j], i - j) * j, dp[i]);
            }
        }
        return dp[n];
    }
}
