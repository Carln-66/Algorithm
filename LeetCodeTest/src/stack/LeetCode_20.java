package stack;


import java.util.Stack;

/**
 * @Auther: Carl
 * @Date: 2021/03/27/13:29
 * @Description: LeetCode #20 有效的括号
 */
class LeetCode_20 {
    public static void main(String[] args) {

        String s = "{}{";
        System.out.println(LeetCode_20.result(s));
    }

    public static boolean result(String s) {
        Stack<Character> stack = new Stack<>();

        if (s.length() % 2 == 0) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '{' || c=='[' || c == '(') {
                    stack.push(c);
                } else if (c == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else if (c == ']') {
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else if (c == '}') {
                    if (!stack.isEmpty() && stack.peek() == '{') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
        return false;
    }
}