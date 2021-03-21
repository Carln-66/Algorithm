package stack;

/**
 * @Auther: Carl
 * @Date: 2021/03/21/9:07
 * @Description:    利用单向链表头插法实现入栈和出栈
 */
public class LinkedListStackTest {
    public static void main(String[] args) {
        LinkedListStack linkedListStack = new LinkedListStack();
        Node node1 = new Node(11);
        Node node2 = new Node(22);
        Node node3 = new Node(33);
        Node node4 = new Node(44);
        Node node5 = new Node(44);
        linkedListStack.push(node1);
        linkedListStack.push(node2);
        linkedListStack.push(node3);
        linkedListStack.push(node4);
        linkedListStack.list();
        System.out.println("-------------------------");
        linkedListStack.pop();
        linkedListStack.pop();
        linkedListStack.pop();
        linkedListStack.list();
        System.out.println("-----------------------------");
        linkedListStack.push(node4);
        linkedListStack.push(node5);
        linkedListStack.list();
    }
}

//栈的操作
class LinkedListStack{
    private Node head = new Node();
    private Node temp = head;       //利用链表盛装数据

    public void push(Node node) {
        if (head == null) {
            head = node;
            return;
        }
        temp = head;
        head = node;
        head.setNext(temp);
    }

    public Node pop(){
        if (head == null){
            throw new RuntimeException("栈为空, 无法删除");
        }
        System.out.println("取出元素: " + head);
        head = head.getNext();
        if (temp == null) {
            temp = new Node(-1);
        }
        temp = temp.getNext();
        return head;
    }

    public void list(){
        if (head == null) {
            System.out.println("链表为空");
        }
        Node pointer = head;
        while (true) {
            if (pointer.getNext() == null) {
                break;
            }
            System.out.println(pointer);
            pointer = pointer.getNext();
        }
    }


}

//定义链表的节点
class Node{
    private int no;
    private Node next;

    public Node() {
    }

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

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                '}';
    }
}
