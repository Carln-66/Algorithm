package strings;

/**
 * @Auther: Carl
 * @Date: 2021/06/23/16:11
 * @Description: 解码方法
 */
public class LeetCode_91 {
    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0' <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[len];
    }
}
