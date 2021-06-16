package array;

import java.util.Arrays;

/**
 * @Auther: Carl
 * @Date: 2021/06/16/17:26
 * @Description: 最长递增子序列
 */
public class LeetCode_300 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length < 2) return 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1); //数组填充1，数组下标的含义是当前最长递增子序列的个数
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {   //从头开始一直到当前i的位置找出现递增的序列元素位置
                if (nums[j] < nums[i]) {    //若找到，比较其他轮次和当前轮次谁的数组下标最大
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int j : dp) {
            res = Math.max(j, res);
        }
        return res;
    }
}
