package LinkedList;

/**
 * @Auther: Carl
 * @Date: 2021/03/20/16:55
 * @Description: 约瑟夫问题
 */
public class JosephusLoop {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addNode(30);
        circleSingleLinkedList.list();

        System.out.println("----------------------------------------------------");
        circleSingleLinkedList.order(2, 4, 30);
    }
}

//创建单向环形链表
class CircleSingleLinkedList {

    //创建一个first节点，当前没有编号
    private Node first = null;

    //添加节点，构成一个环形链表
    public void addNode(int num) {
        //校验输入的num数据
        if (num < 1) {
            System.out.println("输入值不合法");
            return;
        } else {
            Node cur = null;    //辅助指针，帮助构建环形链表
            //使用for循环创建环形链表
            for (int i = 1; i <= num; i++) {
                //根据编号创建节点
                Node node = new Node(i);

                //第一个节点的情况
                if (i == 1) {
                    first = node;
                    first.setNext(first);   //构成环状
                    cur = first;    //让cur指向第一个节点
                } else {
                    cur.setNext(node);  //当前节点指向新创建节点node
                    node.setNext(first);    //新节点node指向初始节点first，形成闭环
                    cur = node; //将中间变量后移至新节点，方便下次循环时使用
                }
            }
        }
    }

    //遍历当前环形链表
    public void list() {
        if (first == null) {
            System.out.println("无任何节点");
            return;
        } else {
            //创建中间变量辅助遍历
            Node node = first;
            while (true) {
                System.out.printf("节点编号：%d\n", node.getNo());
                if (node.getNext() == first) {
                    break;
                }
                node = node.getNext();  //后移
            }
        }
    }

    /**
    * @Author: Carl
    * @Date: 2021/3/20 17:52
    * @param: [startNo, count, total]
    * @return: void
    * @Description:
     * startNo: 表示从第几个节点开始计数
     * count: 表示计数次数
     * total: 表示最初的节点个数
    */
    //根据用户的输入计算节点抹去的顺序
    public void order(int startNo, int count, int total){
        //先对数据校验
        if (first == null || startNo < 1 || startNo > total || count < 0 || total < 1){
            System.out.println("参数输入不合法");
        }

        //创建辅助指针pointer，用于抹去节点
        Node pointer = first;
        //需要将pointer指向first节点之前的一个节点
        while (true) {
            if (pointer.getNext() == first) {
                break;
            }
            pointer = pointer.getNext();
        }

        //通过循环将first和pointer指向输入对应的位置
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            pointer = pointer.getNext();
        }

        while (true) {
            //当pointer和first指针重合时，说明环中只剩下一个节点，此时停止循环
            if (pointer == first) {
                break;
            }
            //开始计数
            for (int i = 0; i < count - 1; i++) {
                first = first.getNext();
                pointer = pointer.getNext();
            }
            System.out.printf("移除%d节点\n", first.getNo());

            //将first指向的节点抹除
            first = first.getNext();
            pointer.setNext(first);
        }
        System.out.printf("最后剩余“%d”节点", first.getNo());
    }
}

//创建一个Node类表示一个节点
class Node {
    private int no; //编号
    private Node next;  //指向下一个节点，默认为null

    public Node(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
