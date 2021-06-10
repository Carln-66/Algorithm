package array;

import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: Carl
 * @Date: 2021/06/10/19:12
 * @Description: 缺失的第一个正数
 */
public class LeetCode_41 {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return nums.length + 1;
    }
}
