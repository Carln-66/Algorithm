package array;

/**
 * @Auther: Carl
 * @Date: 2021/05/10/20:13
 * @Description: 最大子序和
 */
public class LeetCode_53 {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int res = 0;
        for (int num : nums) {
            sum = Math.max(sum + num, num);
            res = Math.max(res, sum);
        }
        return res;
    }
}
