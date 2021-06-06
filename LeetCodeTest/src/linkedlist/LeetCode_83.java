package linkedlist;

import java.util.Stack;

/**
 * @Auther: Carl
 * @Date: 2021/06/06/16:31
 * @Description: 删除排序链表中的重复元素
 */
public class LeetCode_83 {

    public static String removeDuplicates(String s) {
        char[] chars = s.toCharArray();
        int len = s.length();
        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        stack.push('$');
        for (int i = 0; i < len; i++) {
            if (stack.peek().equals(chars[i])) {
                stack.pop();
            } else {
                stack.push(chars[i]);
            }
        }
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.reverse().delete(0, 1).toString();
    }
}
