package strings;

/**
 * @Auther: Carl
 * @Date: 2021/04/29/18:13
 * @Description: #5 最长回文子串
 */
public class LeetCode_5 {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return null;
        }
        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        //L声明的是子串的长度
        for (int L = 2; L <= len; L++) {
            //枚举左边界
            for (int i = 0; i < len; i++) {
                //由字符串长度与左边界的索引可以确定右边界的位置索引为L+i-1
                int j = L + i - 1;
                if (j >= len) {
                    break;
                }
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        //若左右边界的子串长度小于3，说明该子串一定为回文子串
                        dp[i][j] =true;
                    } else {
                        //若子串的长度大于3，则将左右边界除去，继续判断中间的子串是否为回文子串
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                //若当前回文子串长度大于原先的最大长度，则将长度，起始索引更新
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
