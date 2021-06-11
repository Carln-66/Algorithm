package others;

/**
 * @Auther: Carl
 * @Date: 2021/05/15/20:53
 * @Description: 回文数
 */
public class LeetCode_9 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String num = String.valueOf(x);
        char[] chars = num.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
}
