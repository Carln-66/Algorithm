import java.util.HashMap;

/**
 * @Auther: Carl
 * @Date: 2021/06/02/13:10
 * @Description:
 */
public class Practice2 {

    public static void main(String[] args) {
        String s = "babad";
        longestPalindrome(s);
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {i, map.get(target - nums[i])};
            }else {
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }

    public static String longestPalindrome(String s) {
        if (s.length() < 1) {
            return "";
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int odd = expandAroundCentre(s, i, i);
            int even = expandAroundCentre(s, i, i + 1);
            int len = Math.max(odd, even);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end);
    }

    private static int expandAroundCentre(String s, int left, int right) {
        while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }
}
