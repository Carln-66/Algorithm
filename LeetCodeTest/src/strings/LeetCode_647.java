package strings;

/**
 * @Auther: Carl
 * @Date: 2021/07/04/20:13
 * @Description: 回文子串
 */
public class LeetCode_647 {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length() * 2 - 1; i++) {
            int left = i / 2;
            int right = left + i % 2;
            //while判断顺序不能调换
            while ( left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                count++;
            }
        }
        return count;
    }
}
