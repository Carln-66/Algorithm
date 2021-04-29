package array;

import java.util.HashMap;

/**
 * @Auther: Carl
 * @Date: 2021/04/29/17:04
 * @Description: #1 两数之和
 */
public class LeetCode_1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }else {
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}
