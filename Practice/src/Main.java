import java.util.*;

public class Main {
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
