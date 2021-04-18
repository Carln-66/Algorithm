package stack;

import java.util.Stack;

/**
 * @Auther: Carl
 * @Date: 2021/03/29/18:56
 * @Description: LeetCode #32 最长有效括号
 */
public class LeetCode_32 {

    public static void main(String[] args) {
        String s = "(()";
        System.out.println(solution2(s));
    }

    /*
    栈方法概述：遍历char数组，若遇到"("则将其下标入栈，若遇到")"，若当前栈为空，则将该下标入栈，若不为空，比较和之前遍历的最大字符串长度，最后返回最大值

    先将-1入栈，-1用来匹配第一个遇到的合法右括号，给通过该元素下标-(-1)的方法获得该组括号的长度。方法中左括号入栈，正确输入的右括号不入栈，只有当遇到不正确的右括号时会将该位置的下标数入栈，表示计数中断了，需要重新计数。

     */
    public static int solution(String s) {
        char[] chars = s.toCharArray();
        int len = s.length();
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < len; i++) {
            if (chars[i] == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    count = Math.max(i - stack.peek(), count);
                }
            }
        }
        return count;
    }

    /*
    双指针双向扫描方法概述，两个指针left，right同时从数组左侧向右遍历，遇到"("则left加一，遇到")"则right加一，当left=right时则说明遇到了一对正确输入的括号，result++，如果右括号比左括号数量大，即出现了())类似的情况，说明出现不正确输入，记录当前字符串长度值，将left和
   right置零并继续向后遍历。但是当前若出现(()，则left永远不等于right，需要保留result值再从右至左遍历一遍就可解决这种情况。
     */
    public static int solution2(String s){
        int left = 0;
        int right = 0;
        char[] chars = s.toCharArray();
        int len = chars.length;
        int result = 0;
        for (int i = 0; i < len; i++) {
            if (right > left) {
                left = 0;
                right = 0;
            }
            if (chars[i] == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                result = Math.max(result, right * 2);
            }
        }

        left = right = 0;

        for (int i = len -1; i >= 0; i--) {
            if (left > right) {
                left = 0;
                right = 0;
            }
            if (chars[i] == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                result = Math.max(result, left * 2);
            }
        }
        return result;
    }
}

