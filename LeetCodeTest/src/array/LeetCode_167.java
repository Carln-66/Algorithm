package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Carl
 * @Date: 2021/06/14/18:51
 * @Description:
 */
public class LeetCode_167 {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int cur = numbers[i];
            if (map.containsKey(target - cur)) {
                return new int[] {map.get(target - cur) + 1, i + 1};
            }
            map.put(cur, i);
        }
        return new int[0];
    }
}
