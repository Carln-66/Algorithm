package LinkedList;

/**
 * @Auther: Carl
 * @Date: 2021/03/20/15:26
 * @Description: 双向链表
 */
public class DoubleLinkedListTest {
    public static void main(String[] args) {
        //测试
        PersonNode1 node1 = new PersonNode1(1, "宋江", "及时雨");
        PersonNode1 node2 = new PersonNode1(2, "卢俊义", "玉麒麟");
        PersonNode1 node3 = new PersonNode1(3, "吴用", "智多星");
        PersonNode1 node4 = new PersonNode1(4, "公孙胜", "入云龙");
        PersonNode1 node5 = new PersonNode1(5, "关胜", "大刀");
        PersonNode1 node6 = new PersonNode1(6, "林冲", "豹子头");
        PersonNode1 node7 = new PersonNode1(7, "秦明", "霹雳火");
        PersonNode1 node8 = new PersonNode1(8, "呼延灼", "双鞭");
        PersonNode1 node9 = new PersonNode1(9, "花荣", "小李广");
        PersonNode1 node10 = new PersonNode1(10, "柴进", "小旋风");
        PersonNode1 node11 = new PersonNode1(11, "李应", "扑天雕");
        PersonNode1 node12 = new PersonNode1(12, "朱仝", "美髯公");
        PersonNode1 node13 = new PersonNode1(13, "鲁智深", "花和尚");
        PersonNode1 node14 = new PersonNode1(14, "武松", "行者");
        PersonNode1 node15 = new PersonNode1(15, "董平", "双枪将");
        PersonNode1 node16 = new PersonNode1(16, "张清", "没羽箭");
        PersonNode1 node17 = new PersonNode1(17, "扬志", "青面兽");
        PersonNode1 node18 = new PersonNode1(18, "徐宁", "金枪手");
        PersonNode1 node19 = new PersonNode1(19, "索超", "急先锋");

        //创建双向链表对象
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(node1);
        doubleLinkedList.add(node2);
        doubleLinkedList.add(node3);
        doubleLinkedList.add(node4);
        doubleLinkedList.add(node5);
        doubleLinkedList.add(node6);
        doubleLinkedList.add(node7);
        doubleLinkedList.add(node8);
        doubleLinkedList.add(node9);
        doubleLinkedList.add(node10);
        doubleLinkedList.add(node11);
        doubleLinkedList.add(node12);
        doubleLinkedList.add(node13);
        doubleLinkedList.add(node14);
        doubleLinkedList.add(node15);
        doubleLinkedList.add(node16);
        doubleLinkedList.add(node17);
        doubleLinkedList.add(node18);
        doubleLinkedList.add(node19);

        System.out.println("**********************************************************");
        //显示
        doubleLinkedList.list();

        System.out.println("**********************************************************");
        //修改
        doubleLinkedList.update(new PersonNode1(19, "Ziyu", "Carl"));
        doubleLinkedList.list();

        System.out.println("**********************************************************");
        //删除
        doubleLinkedList.del(19);
        doubleLinkedList.list();
    }
}

//创建一个双向链表的类
class DoubleLinkedList {

    //先初始化一个头节点，头节点不能移动，并且不存放具体的数据
    private PersonNode1 head = new PersonNode1(0, "", "");

    //返回头节点
    public PersonNode1 getHead() {
        return head;
    }

    //遍历双向链表
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
        }
        //头节点无法移动，添加中间变量temp
        PersonNode1 temp = head.next;
        while (true) {
            //判断链表是否到最后
            if (temp == null) {
                break;
            }
            //输出
            System.out.println(temp);
            temp = temp.next;
        }
    }

    //添加节点
    public void add(PersonNode1 PersonNode1) {
        PersonNode1 temp = head;
        //遍历，查询到最后
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        //退出while循环时，temp指向了链表最后
        //形成一个双向链表
        temp.next = PersonNode1;
        PersonNode1.pre = temp;
    }

    //修改节点的信息，根据no编号来修改，即no编号不能改
    //说明
    //1. 根据PersonNode1的no修改即可
    public void update(PersonNode1 PersonNode1) {
        //判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        //找到需要修改的节点，根据no编号
        //定义一个中间变量
        PersonNode1 temp = head;
        boolean flag = false;   //表示是否找到该节点
        while (true) {
            if (temp == null) {
                break;  //已经到了链表的结尾
            }
            if (temp.no == PersonNode1.no) {
                //找到了该节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到要修改的节点
        if (flag) {
            temp.name = PersonNode1.name;
            temp.nickname = PersonNode1.nickname;
        } else {    //未找到该节点信息
            System.out.printf("未能找到编号为%d的节点，无法修改\n", PersonNode1.no);
        }
    }

    //从双向链表中删除节点
    //说明
    //1. 对于双向链表，中间变量temp可以直接定位到要删除的节点处，无需停留在它前一个节点的位置
    //2. 找到后自我删除即可
    public void del(int no) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        PersonNode1 temp = head;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            //以下代码在no为链表最末节点时会出现空指针异常
//            temp.next.pre = temp.pre;
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.println("未找到该编号的节点");
        }
    }
}

//定义一个PersonNode1，每一个PersonNode1对象就是一个节点
class PersonNode1 {
    public int no;
    public String name;
    public String nickname;
    public PersonNode1 next; //指向下一个节点，默认为null
    public PersonNode1 pre; //指向前一个节点，默认为null

    public PersonNode1(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    //为了显示方便，重写toString
    @Override
    public String toString() {
        return "PersonNode1{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}

