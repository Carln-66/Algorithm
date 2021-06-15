package tree;

/**
 * @Auther: Carl
 * @Date: 2021/06/08/17:47
 * @Description: 不同的二叉搜索树
 */
public class LeetCode_96 {
    //动态规划 + 卡特兰数
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    //数学解法
    public int numTrees1(int n) {
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2L * i + 1) / (i + 2);
        }
        return (int) C;
    }
}
