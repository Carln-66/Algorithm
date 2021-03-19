package Queue;

import java.util.Scanner;

/**
 * @Auther: Carl
 * @Date: 2021/03/19/10:39
 * @Description: 环形数组队列
 */
public class CircleArrayQueueTest {
    public static void main(String[] args) {
        System.out.println("测试");
        CircleArray circleArray = new CircleArray(4);
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
                    circleArray.showQueue();
                    break;
                case 'e':
                    s.close();
                    loop = false;
                    break;
                case 'a':
                    System.out.println("请输入需要添加的数据");
                    int i = s.nextInt();
                    circleArray.addQueue(i);
                    break;
                case 'g':
                    try {
                        int result = circleArray.getQueue();
                        System.out.printf("取出数据为：%d\n",result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int front = circleArray.getFront();
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

class CircleArray{
    private int maxsize;    //数组的最大容量
    private int rear;       //指向队列最后一个元素的后一个位置
    private int front;      //队列首部，指向队列的第一个元素
    private int[] arr;      //该数据用于存放数据，模拟队列

    public CircleArray(int arrMaxSize) {
        maxsize = arrMaxSize;
        arr = new int[maxsize];
        front = 0;
        rear = 0;
    }

    //判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxsize == front;
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
            //直接将数据加入
            arr[rear] = n;
            //将rear后移，这里必须考虑取模
            rear = (rear + 1) % maxsize;
        }
    }

    //取出队列头部的数据，出队列
    public int getQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            //通过抛异常处理
            throw new RuntimeException("队列为空");
        } else {
            //分析出front是指向队列的第一个元素
            //1. 先把front对应的值保留到一个临时变量
            //2. 将front后移，考虑取模
            //3. 将临时保存的变量返回
            int value = arr[front];
            front = (front + 1)% maxsize;
            return value;
        }
    }

    //显示队列的所有数据
    public void showQueue() {
        //遍历
        if (isEmpty()) {
            System.out.println("队列为空，无数据");
        } else {
            //思路：从front开始遍历，遍历多少个元素
            for (int i = front; i < front + size(); i++) {
                System.out.printf("arr[%d] = %d\n", i % maxsize, arr[i % maxsize]);
            }
        }
    }

    //求出当前队列有效数据的个数
    public int size(){
        return (rear + maxsize - front) % maxsize;
    }

    //显示队列头数据
    public int getFront() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无数据");
        }
        return arr[front];
    }
}
