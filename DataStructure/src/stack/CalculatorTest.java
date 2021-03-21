package stack;

/**
 * @Auther: Carl
 * @Date: 2021/03/21/11:21
 * @Description:
 */
public class CalculatorTest {
    public static void main(String[] args) {
        //根据思路完成表达式运算
        String expression = "7-6-1-8";


        //创建两个栈，一个为数栈：存放数据；一个为符号栈：存放运算符
        ArrayStack1 numStack = new ArrayStack1(10);
        ArrayStack1 operatorStack = new ArrayStack1(10);

        //定义需要的相关变量
        int index = 0;  //用于扫描栈中元素
        int num1 = 0;
        int num2 = 0;
        int operator = ' ';
        int result = 0;
        char ch = ' ';  //将每次扫描得到的char保存到ch中
        String tool = "";   //用于拼接多位数字

        //用while语句循环扫描expression
        while (true) {
            //先依次得到expression中的每一个字符
            ch = expression.substring(index, index + 1).charAt(0);

            //判断ch是数字还是符号，并对其进行相应的处理
            if (operatorStack.isOperator(ch)) { //如果是运算符
                //判断当前符号栈是否为空
                if (operatorStack.isEmpty()) {
                    //如果为空，直接入栈
                    operatorStack.push(ch);
                } else if (!operatorStack.isEmpty()) {
                    //如果符号栈有操作符，就进行比较，如果当前操作符的优先级小于或等于栈中的操作符，就需要从数栈中pop出两个数
                    //再从符号栈中pop出一个符号进行运算。得到的结果压入数栈，然后将当前的操作符入符号栈
                    if (operatorStack.priority(ch) <= operatorStack.priority(operatorStack.show())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        operator = operatorStack.pop();
                        result = numStack.calculate(num1, num2, operator);

                        //将运算结果压入数栈
                        numStack.push(result);

                        //将当前操作符入符号栈
                        operatorStack.push(ch);
                    } else {
                        //如果当前操作符的有消极大于栈中的操作符，就直接入符号栈
                        operatorStack.push(ch);
                    }
                }
            } else {
                //如果是数，则直接入数栈，由于ASCII表数字对应的值相差48，所以要进行相应的运算
                //但是下列算法无法判断多位数，因为在发现一个数字时直接将其压入栈
//                numStack.push(ch - 48);

                //处理数字时，需要向expression的表达式的index后再查找一位，如果是运算符，则将前面的数字压入栈，如果视数字，则继续查找
                //需要定义一个字符串变量tool用于拼接
                tool += ch;

                //如果ch已经是expression的最后一位，直接入栈
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(tool));
                } else {
                    //判断下一个字符是否为数字
                    //如果是数字，则继续扫描；如果是运算符，则入栈
                    if (operatorStack.isOperator(expression.substring(index+1, index+2).charAt(0))){
                        //如果后一位是运算符，则入栈
                        numStack.push(Integer.parseInt(tool));

                        //*********记得清空tool*********
                        tool = "";
                    }
                }
            }
            //让index+1，并判断是否扫描到expression的最后
            index++;
            if (index >= expression.length()) { //此时已经到表达式末尾
                break;
            }
        }

        //表达式扫描结束，从数栈和符号栈中弹出相应的符号的数字，并加以运算
        while (true) {
            //循环结束条件：符号栈为空，则计算最后的结果，数栈中只有唯一的结果
            if (operatorStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            operator = operatorStack.pop();
            result = numStack.calculate(num1, num2, operator);
            numStack.push(result);
        }

        //将数栈最后的结果弹出
        System.out.printf("表达式%s = %d", expression, numStack.pop());
    }
}

//创建一个基于数组的栈
class ArrayStack1 {
    private int maxSize;    //栈的大小
    private int[] stack;    //用此数组模拟栈，数据存放在该数组中
    private int top = -1;   //top表示栈顶，初始化为-1

    //构造器
    public ArrayStack1(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int value) {
        //先判断栈是否满
        if (isFull()) {
            System.out.println("栈已满");
            return;
        } else {
            top++;
            stack[top] = value;
        }
    }

    //出栈
    public int pop() {
        //先判断栈是否为空
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //遍历栈
    //遍历时，需要从栈顶显示数据
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        } else {
            for (int i = top; i >= 0; i--) {
                System.out.printf("stack[%d] = %d\n", i, stack[i]);
            }
        }
    }

    //功能扩展：返回运算符的优先级，优先级由程序决定，使用数字表示，数字越大，优先级越高
    public int priority(int operator) {
        if (operator == '*' || operator == '/') {
            return 1;
        } else if (operator == '+' || operator == '-') {
            return 0;
        } else {
            return -1;  //假定目前的表达式只有+，-，*，/
        }
    }

    //判断输入是否是运算符
    public boolean isOperator(char par) {
        return par == '+' || par == '-' || par == '*' || par == '/';
    }

    //运算方法
    public int calculate(int num1, int num2, int operator) {
        int result = 0; //用于存放运算结果
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num2 - num1;   //后面的数作为减数
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num2 / num1;
                break;
            default:
                break;
        }
        return result;
    }

    //返回当前栈顶的值，但不弹出栈
    public int show() {
        return stack[top];
    }
}
