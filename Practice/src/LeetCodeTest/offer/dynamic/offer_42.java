package LeetCodeTest.offer.dynamic;

/**
 * @Auther: Carl
 * @Date: 2021/04/14/15:49
 * @Description: #42  连续子数组的最大和
 */
public class offer_42 {
    //利用动态规划
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);    //计算前一位数字是否小于0
            res = Math.max(res, nums[i]);           //返回当前结果
        }
        return res;
    }
}
