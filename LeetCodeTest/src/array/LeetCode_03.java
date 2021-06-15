package array;

/**
 * @Auther: Carl
 * @Date: 2021/06/04/13:28
 * @Description: 数组中重复的数字
 */
public class LeetCode_03 {
    public int findRepeatNumber(int[] nums) {
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (temp == nums[nums[i]]) {
                    return temp;
                }
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }
}
