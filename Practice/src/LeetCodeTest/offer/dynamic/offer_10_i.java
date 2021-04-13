package LeetCodeTest.offer.dynamic;

/**
 * @Auther: Carl
 * @Date: 2021/04/08/23:20
 * @Description: 剑指offer #10-i   斐波那契数列
 */
public class offer_10_i {
    //利用动态规划
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] %= 1000000007;
        }
        return dp[n];
    }
}
