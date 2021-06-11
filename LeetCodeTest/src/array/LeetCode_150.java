package array;

import java.util.Stack;

/**
 * @Auther: Carl
 * @Date: 2021/06/11/12:53
 * @Description: 逆波兰表达式求值
 */
public class LeetCode_150 {
    public static void main(String[] args) {
        String[] arr = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(arr));
    }
    public static int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].matches("^-?[0-9]\\d*$")) {
                stack.push(tokens[i]);
            } else {
                int result = 0;
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                switch (tokens[i]) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num2 - num1;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        result = num2 / num1;
                        break;
                }
                stack.push(result + "");
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
