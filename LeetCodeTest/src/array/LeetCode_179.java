package array;

import java.util.Arrays;

/**
 * @Auther: Carl
 * @Date: 2021/06/12/14:32
 * @Description: 最大数
 */
public class LeetCode_179 {
    public String largestNumber(int[] nums) {
        String[] stringNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            stringNums[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(stringNums, (a, b) -> {
            return (b + a).compareTo(a + b);
        });
        if (stringNums[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String stringNum : stringNums) {
            sb.append(stringNum);
        }
        return sb.toString();
    }
}
