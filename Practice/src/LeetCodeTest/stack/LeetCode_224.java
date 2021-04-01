package LeetCodeTest.stack;

import java.util.Stack;

/**
 * @Auther: Carl
 * @Date: 2021/03/28/8:50
 * @Description: LeetCode #224 基本计算器(不考虑乘除和小数)
 */
public class LeetCode_224 {

    public static void main(String[] args) {
        String s = "30";
        System.out.println(LeetCode_224.calculate(s));
    }


    public static int calculate(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<Integer> operatorStack = new Stack<>();
        char[] chars = s.toCharArray();
        int len = s.length();
        int result = 0;
        int sign = 1;

        for (int i = 0; i < len; i++) {
            //考虑空格
            if (chars[i] == ' ') {
                continue;
            }
            //考虑运算符
            if (chars[i] == '+' || chars[i] == '-') {
                sign = chars[i] == '+' ? 1 : -1;
            }
            //考虑数字
            else if (chars[i] >= '0' && chars[i] <= '9') {
                //需要考虑数字的长度
                int num = chars[i] - '0';
                while (i < len - 1 && chars[i + 1] >= '0' && chars[i + 1] <= '9') {
                    num = num * 10 + chars[++i] - '0';
                }
                //存入结果
                result = sign * num + result;
            }
            //考虑左括号，进栈
            else if (chars[i] == '(') {
                numStack.push(result);
                operatorStack.push(sign);
                result = 0;
                sign = 1;
            }
            //考虑右括号
            else {
                result = numStack.pop() + operatorStack.pop() * result;
            }
        }
        return result;
    }
}
