import java.util.Stack;

/**
 * @Auther: Carl
 * @Date: 2021/03/29/18:18
 * @Description:
 */
public class Preview {

    public static void main(String[] args) {
        String s = "-    (1 -3)+2-4+((1+1)-1)";
        System.out.println(solution(s));

    }

    public static int solution(String s){
        Stack<Integer> numStack = new Stack<>();
        Stack<Integer> operatorStack = new Stack<>();

        int len = s.length();
        char[] chars = s.toCharArray();
        int result = 0;
        int operator = 1;


        for (int i = 0; i < len; i++) {
            //空串
            if (chars[i] == ' ') {
                continue;
            }
            //基本运算符
            if (chars[i] == '+' || chars[i] == '-') {
                operator = chars[i] == '+' ? 1 : -1;
            }
            //数字
            else if (chars[i] >= '0' && chars[i] <= '9') {
                int num = chars[i] - '0';
                while (i < len - 1 && chars[i + 1] >= '0' && chars[i + 1] <= '9') {
                    num = num * 10 + chars[++i] - '0';
                }
                result = num * operator + result;
            }
            //“（”
            else if (chars[i] == '(') {
                numStack.push(result);
                operatorStack.push(operator);
                result = 0;
                operator = 1;
            }
            //")"
            else {
                result = operatorStack.pop() * result + numStack.pop();
            }
        }
        return result;
    }
}
