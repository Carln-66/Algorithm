package stack;

import java.util.Scanner;

/**
 * @Auther: Carl
 * @Date: 2021/03/21/8:29
 * @Description:    利用数组模拟栈结构
 */
public class ArrayStackTest {
    public static void main(String[] args) {

        //测试
        //创建ArrayStack对象
        ArrayStack arrayStack = new ArrayStack(4);
        String key = "";
        boolean loop = true;
        Scanner s = new Scanner(System.in);

        while (loop) {
            System.out.println("---------------------------------------------");
            System.out.println("show: 显示栈");
            System.out.println("push: 添加数据");
            System.out.println("pop: 删除数据");
            System.out.println("exit: 退出程序");
            System.out.println();
            System.out.println("选择要执行的操作：");
            key = s.next();
            System.out.println("---------------------------------------------");

            switch (key) {
                case "show":
                    arrayStack.list();
                    break;
                case "push":
                    System.out.println("请输入添加的数据");
                    int i = s.nextInt();
                    arrayStack.push(i);
                    break;
                case "pop":
                    try {
                        int pop = arrayStack.pop();
                        System.out.println("取出数据：" + pop);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    s.close();
                    loop = false;
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

//用ArrayStack表示栈结构
class ArrayStack{
    private int maxSize;    //栈的大小
    private int[] stack;    //用此数组模拟栈，数据存放在该数组中
    private int top = -1;   //top表示栈顶，初始化为-1

    //构造器
    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //栈满
    public boolean isFull(){
        return top == maxSize-1;
    }

    //栈空
    public boolean isEmpty(){
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
    public int pop(){
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
}
