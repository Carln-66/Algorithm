import java.util.HashMap;

/**
 * @Auther: Carl
 * @Date: 2021/06/06/20:33
 * @Description: x的平方根
 */
public class LeetCode_69 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {i, map.get(target - nums[i])};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[0];
    }
}
