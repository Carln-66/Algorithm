package Queue;


import java.util.Scanner;

/**
 * @Auther: Carl
 * @Date: 2021/03/19/9:05
 * @Description: 数组模拟队列
 *  程序仍有问题，数组是一次性的，无法复用。
 *  优化：将数组使用算法，该进程一个环形的数组
 */
public class ArrayQueueTest {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' '; //接收用户输入
        Scanner s = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("---------------------------------------");
            System.out.println("s(show)：显示队列");
            System.out.println("e(exit)：退出程序");
            System.out.println("a(add)：添加数据队列");
            System.out.println("g(get)：从队列取出数据");
            System.out.println("h(head)：查看队列头的数据");
            System.out.println("---------------------------------------");

            key = s.next().charAt(0);   //接收第一个字符
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'e':
                    s.close();
                    loop = false;
                    break;
                case 'a':
                    System.out.println("请输入需要添加的数据");
                    int i = s.nextInt();
                    arrayQueue.addQueue(i);
                    break;
                case 'g':
                    try {
                        int result = arrayQueue.getQueue();
                        System.out.printf("取出数据为：%d\n",result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int front = arrayQueue.getFront();
                        System.out.printf("头部数据为：%d\n", front);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

//使用数组模拟队列编写一个ArrayQueue的类
class ArrayQueue {
    private int maxsize;    //数组的最大容量
    private int rear;       //队列尾部
    private int front;      //队列首部
    private int[] arr;      //该数据用于存放数据，模拟队列

    //创建队列的构造器
    public ArrayQueue(int arrMaxSize) {
        maxsize = arrMaxSize;
        arr = new int[maxsize];
        front = -1; //指向队列头部，具体指队列头部的前一个位置
        rear = -1;  //指向队列尾部，指向队列尾的数据(即队列最后一个数据)
    }

    //判断队列是否满
    public boolean isFull() {
        return rear == maxsize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n) {
        //判断队列是否满员
        if (isFull()) {
            System.out.println("队列已满，无法添加数据");
            return;
        } else {
            rear++; //rear后移
            arr[rear] = n;
        }
    }

    //取出队列头部的数据，出队列
    public int getQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            //通过抛异常处理
            throw new RuntimeException("队列为空");
        } else {
            front++;    //front后移一位
            return arr[front];
        }
    }

    //显示队列的所有数据
    public void showQueue() {
        //遍历
        if (isEmpty()) {
            System.out.println("队列为空，无数据");
        } else {
            for (int i = 0; i < arr.length; i++) {
                System.out.printf("arr[%d] = %d\n", i, arr[i]);
            }
        }
    }

    //显示队列头数据
    public int getFront() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无数据");
        }
        return arr[front + 1];
    }
}
