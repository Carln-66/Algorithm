package array;

/**
 * @Auther: Carl
 * @Date: 2021/06/06/16:29
 * @Description: 删除有序数组中的重复项
 */
public class LeetCode_26 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int fast = 1;
        int slow = 0;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }
}
