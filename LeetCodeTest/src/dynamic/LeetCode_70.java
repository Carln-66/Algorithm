package dynamic;

/**
 * @Auther: Carl
 * @Date: 2021/06/03/14:51
 * @Description: 爬楼梯
 */
public class LeetCode_70 {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
