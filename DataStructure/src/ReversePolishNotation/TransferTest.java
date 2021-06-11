package ReversePolishNotation;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Auther: Carl
 * @Date: 2021/03/22/16:42
 * @Description: 中缀表达式转后缀表达式
 */
public class TransferTest {
    public static void main(String[] args) {

        //将中缀表达式转为后缀表达式

        //演示示例：1+((2+3)*4)-5 -> 1 2 3 + 4 * 5 -
        //由于对str直接操作不方便，所以先将1+((2+3)*4)-5表达式的中缀形式每个元素依次存入对应的ArrayList中
        String expression = "1+((2+33)*4)-5";
        List<String> strings = toInfixExpression(expression);
        System.out.println(strings);
//        System.out.println(parseSuffixExpressionList(strings));
        System.out.println(calculate(parseSuffixExpressionList(strings)));

        //假定一个目标表达式
        //(3+4)*5-6 -> 3 4 + 5 * 6 -
        //为了说明方便，逆波兰表达式数字与符号之间使用空格隔开
        String suffixExpression = "3 4 + 5 * 6 -";
        /**
         * 思路：
         * 1. 先将需要运算的"3 4 + 5 * 6 -"放入ArrayList中
         * 2. 将ArrayList传递给一个方法，遍历ArrayList，配合栈完成计算
         */

//        List<String> testList = getListString(suffixExpression);
//        System.out.println(testList);
//        int calculate = calculate(testList);
//        System.out.println(calculate);
    }

    //方法：将中缀表达式转换为对应的List
    public static List<String> toInfixExpression(String s) {
        //定义一个List，存放中缀表达式对应的元素
        List<String> list = new ArrayList<>();
        int i = 0;  //定义一个指针，用于遍历原表达式字符串
        String str; //用于对多位数拼接
        char c; //每遍历一个字符就放入c中
        do {
            //如果c为非数字，则需要加入list
            if ((c = s.charAt(i)) < 48  || (c = s.charAt(i)) > 57) {
                list.add("" + c);
                i++;
            } else { //如果c是一个数字，考虑多位数问题
                //先将str置空
                str = "";
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    //拼接字符串
                    str += c;
                    i++;
                }
                list.add(str);
            }
        } while (i < s.length());
        return list;
    }

    //方法：将得到的中缀表达式对应的list转换为后缀表达式对应的list，消除括号
    public static List<String> parseSuffixExpressionList(List<String> list) {
        //定义两个栈
        Stack<String> s1 = new Stack<>();   //符号栈

        //由于s2栈在整个操作过程中没有弹出操作，并且在后续操作中需要逆序输出，因而不将其设置为栈结构，用ArrayList将其代替
//        Stack<String> stack = new Stack<>();
        List<String> s2 = new ArrayList<>();

        //遍历list
        for (String item : list){
            //如果item为数字，则入s2
            if (item.matches("^[0-9]*$")){
                s2.add(item);
            } else if (item.equals("(")) {  //若为左括号，则继续压入s1
                s1.push(item);
            } else if (item.equals(")")){   //若为右括号，开始向下弹出
                while (!s1.peek().equals("(")) {     //最后直至左括号（左括号未在循环内，未被弹出）
                    s2.add(s1.pop());
                }
                //将while循环最终剩下的左括号弹出
                s1.pop();
            } else {
                //若该运算符运算优先级小于等于栈顶运算符的优先级，则将栈顶运算符弹出并存入s2，再与新的栈顶运算符比较
                //在此加入判断优先级高低的方法
                while (s1.size() != 0 && (Operation.getValue(s1.peek()) >= Operation.getValue(item))) {
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }
        //将s1中剩余的运算符依次弹出并压入s2
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }
        return s2;
    }


//    //将逆波兰表达式中的数据和运算符依次放入ArrayList中
//    public static List<String> getListString(String suffixExpression) {
//        //分割suffixExpression
//        String[] split = suffixExpression.split(" ");
//        ArrayList<String> arrayList = new ArrayList<>();
//        for (String elements : split) {
//            arrayList.add(elements);
//        }
//        return arrayList;
//    }

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
        Stack<String> stack = new Stack<>();
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
                stack.push("" + result);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}

//判断运算符优先级的类
class Operation{
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    //返回对应的优先级数
    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
        }
        return result;
    }
}