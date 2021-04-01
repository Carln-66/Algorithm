import java.util.Stack;

/**
 * @Auther: Carl
 * @Date: 2021/03/29/18:18
 * @Description:
 */
public class Preview {
    public static void main(String[] args) {
        String s = "(1+5  ) -( 2-1)+(1+1+1-5)";
        System.out.println(Preview.calculate(s));
    }

    public static int calculate(String s) {
        char[] chars = s.toCharArray();
        Stack<Integer> numStack = new Stack<>();
        Stack<Integer> operatorStack = new Stack<>();
        int len = s.length();
        int operator = 1;
        int res = 0;

        for (int i = 0; i < len; i++) {
            if (chars[i] == ' ') {
                continue;
            }
            //考虑数字
            if (chars[i] >= '0' && chars[i] <= '9') {
                int num = chars[i] - '0';
                while (i < len - 1 && chars[i + 1] >= '0' && chars[i + 1] <= '9') {
                    num = chars[i] * 10 + chars[++i] - '0';
                }
                res = num * operator + res;
            }
            //考虑运算符
            else if (chars[i] == '+' || chars[i] == '-') {
                operator = chars[i] == '+' ? 1 : -1;
            }
            //考虑左括号
            else if (chars[i] == '(') {
                numStack.push(res);
                operatorStack.push(operator);
                res = 0;
                operator = 1;
            }
            else  {
                res = numStack.pop() + res * operatorStack.pop();
            }
        }
        return res;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}