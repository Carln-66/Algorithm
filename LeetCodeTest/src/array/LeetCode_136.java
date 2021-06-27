package array;

/**
 * @Auther: Carl
 * @Date: 2021/06/27/16:23
 * @Description: 只出现一次的数字
 */
public class LeetCode_136 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
