package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: Carl
 * @Date: 2021/05/04/19:02
 * @Description: #15 三数之和
 */
public class LeetCode_15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (nums == null || len < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;    //去重
                    while (left < right && nums[right] == nums[right - 1]) right--; //去重
                    left++;
                    right--;
                }
                else if (sum < 0) left++;
                else if (sum > 0) right--;
            }
        }
        return res;
    }
}
