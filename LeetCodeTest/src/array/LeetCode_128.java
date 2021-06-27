package array;

import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: Carl
 * @Date: 2021/06/27/16:17
 * @Description: 最长连续序列
 */
public class LeetCode_128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int curNum = num;
                int curLength = 1;
                while (set.contains(curNum + 1)) {
                    curNum += + 1;
                    curLength += 1;
                }
                res = Math.max(res, curLength);
            }
        }
        return res;
    }
}
