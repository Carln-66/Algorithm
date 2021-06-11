package ReversePolishNotation;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Auther: Carl
 * @Date: 2021/03/22/16:42
 * @Description:    后缀表达式（逆波兰表达式）实现计算器基本功能
 */
public class ReversePolishNotationTest {
    public static void main(String[] args) {
        //假定一个目标表达式
        //(3+4)*5-6 -> 3 4 + 5 * 6 -
        //为了说明方便，逆波兰表达式数字与符号之间使用空格隔开
        String suffixExpression = "4 13 5 / +";
        /**
         * 思路：
         * 1. 先将需要运算的"3 4 + 5 * 6 -"放入ArrayList中
         * 2. 将ArrayList传递给一个方法，遍历ArrayList，配合栈完成计算
         */

        List<String> testList = getListString(suffixExpression);
        System.out.println(testList);
        int calculate = calculate(testList);
        System.out.println(calculate);
    }

    //将逆波兰表达式中的数据和运算符依次放入ArrayList中
    public static List<String> getListString(String suffixExpression) {
        //分割suffixExpression
        String[] split = suffixExpression.split(" ");
        ArrayList<String> arrayList = new ArrayList<>();
        for (String elements : split) {
            arrayList.add(elements);
        }
        return arrayList;
    }

    //完成对逆波兰表达式的运算
    /*
    运算顺序：3 4 + 5 * 6 -
    1. 从左至右依次扫描，将3与4压入堆栈
    2. 遇到+运算符，因此弹出4和3（4为栈顶元素，3为次顶元素），然后计算3+4的值，求出结果7后将7压入栈
    3. 将5入栈
    4. 接下来是*运算符，因此弹出5和7，计算7*5=35，将35入栈
    5. 将6入栈
    6. 最后是-运算符，计算35-6的值，即29，由此最终得出结果
     */

    public static int calculate(List<String> ls) {
        //创建一个栈（只需要一个栈即可）
        Stack<String> stack = new Stack<String>();
        //遍历ls
        for (String item : ls) {
            //这里使用正则表达式取出数
            if (item.matches("\\d+")) { //匹配的是多位数
                //入栈
                stack.push(item);
            } else {
                //如果不是数字，则弹出两个数，进行运算
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int result;
                if (item.equals("+")) {
                    result = num1 + num2;
                } else if (item.equals("-")) {
                    result = num1 - num2;
                } else if (item.equals("*")) {
                    result = num1 * num2;
                } else if (item.equals("/")) {
                    result = num1 / num2;
                } else {
                    throw new RuntimeException("输入运算符有误");
                }
                //将result入栈
                stack.push(""+result);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
