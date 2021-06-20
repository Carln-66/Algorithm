package dynamic;

/**
 * @Auther: Carl
 * @Date: 2021/06/20/17:01
 * @Description: 编辑举例
 */
public class LeetCode_72 {
    public int minDistance(String word1, String word2) {
        int x = word1.length();
        int y = word2.length();
        //如果两个字符串有一个是空串，那么编辑距离就是另外一个字符串的长度
        if (x * y == 0) {
            return x + y;
        }
        //初始化dp[][]数组边界条件，如果数组边界有一个是0，则说明是一个空串和另外一个字符串子串的编辑长度，等于另外一个字符串子串的编辑长度
        int[][] dp = new int[x + 1][y + 1];
        for (int i = 0; i < x + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < y + 1; i++) {
            dp[0][i] = i;
        }
        /*
        将i和j不为0的位置赋值，由动态规划将分为以下三种子问题
        字符串一删除一个字符：需要加上当次操作数+1
        字符串二删除一个字符：需要加上当次操作数+1
        字符串一和二同时删除一个字符：需要比较删除后末尾位置字符是否相等，如果不相等继续删除

        最后比较三种情况中所需操作最少的那一个
         */
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
