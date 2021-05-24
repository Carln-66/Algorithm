package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Auther: Carl
 * @Date: 2021/05/22/23:35
 * @Description: 反转每对括号间的子串
 */
public class LeetCode_1190 {
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        StringBuilder res = new StringBuilder();
        for (char aChar : chars) {
            if (aChar != ')') {
                stack.push(aChar);
            } else {
                List<Character> list = new ArrayList<>();
                while (!(stack.peek() == '(')) {
                    Character pop = stack.pop();
                    list.add(pop);
                }
                stack.pop();
                for (char c : list) {
                    stack.push(c);
                }
            }
        }
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }
}
