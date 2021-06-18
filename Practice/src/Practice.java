import java.util.Stack;

public class Practice {
    public int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (right > left) {
                right = left = 0;
            }
            if (chars[i] == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                sum = Math.max(sum, right * 2);
            }
        }
        right = left = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (left > right) {
                right = left = 0;
            }
            if (chars[i] == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                sum = Math.max(sum, left * 2);
            }
        }
        return sum;
    }
}
