package offer.array;

import java.util.Stack;

/**
 * @Auther: Carl
 * @Date: 2021/04/06/19:13
 * @Description:   剑指offer #05 替换空格
 */
public class offer_05 {

    public static void main(String[] args) {
        String s = "   sad 21 ";
        String s1 = replaceSpace2(s);
        System.out.println(s1);
    }
    public static String replaceSpace(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                stack.push('0');
                stack.push('2');
                stack.push('%');
            } else {
                stack.push(s.charAt(i));
            }
        }
        String s1 = "";
        while (!stack.isEmpty()) {
            Character pop = stack.pop();
            s1 += pop;
        }
        return s1;
    }

    //调用函数库replace方法
    public static String replaceSpace1(String s) {
        String replace = s.replace(" ", "%20");
        return replace;
    }

    //使用StringBuilder
    public static String replaceSpace2(String s) {
        StringBuilder res = new StringBuilder();
        for (Character c : s.toCharArray()) {
            if (c == ' ') {
                res.append("%20");
            }else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
