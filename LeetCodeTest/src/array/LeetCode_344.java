package array;

/**
 * @Auther: Carl
 * @Date: 2021/06/10/19:28
 * @Description: 反转字符串
 */
public class LeetCode_344 {
    public void reverseString(char[] s) {
        if (s.length == 0) return;
        for (int i = 0; i < s.length / 2; i++) {
            if (s.length - i == i) return;
            char temp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = temp;
        }
    }

}
