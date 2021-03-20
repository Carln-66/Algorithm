package LinkedList;

import java.util.Stack;

/**
 * @Auther: Carl
 * @Date: 2021/03/19/13:40
 * @Description: 水浒传人物通过链表形式实现
 */
public class SingleLinkedListTest {
    public static void main(String[] args) {
        //测试
        PersonNode node1 = new PersonNode(1, "宋江", "及时雨");
        PersonNode node2 = new PersonNode(2, "卢俊义", "玉麒麟");
        PersonNode node3 = new PersonNode(3, "吴用", "智多星");
        PersonNode node4 = new PersonNode(4, "公孙胜", "入云龙");
        PersonNode node5 = new PersonNode(5, "关胜", "大刀");
        PersonNode node6 = new PersonNode(6, "林冲", "豹子头");
        PersonNode node7 = new PersonNode(7, "秦明", "霹雳火");
        PersonNode node8 = new PersonNode(8, "呼延灼", "双鞭");
        PersonNode node9 = new PersonNode(9, "花荣", "小李广");
        PersonNode node10 = new PersonNode(10, "柴进", "小旋风");
        PersonNode node11 = new PersonNode(11, "李应", "扑天雕");
        PersonNode node12 = new PersonNode(12, "朱仝", "美髯公");
        PersonNode node13 = new PersonNode(13, "鲁智深", "花和尚");
        PersonNode node14 = new PersonNode(14, "武松", "行者");
        PersonNode node15 = new PersonNode(15, "董平", "双枪将");
        PersonNode node16 = new PersonNode(16, "张清", "没羽箭");
        PersonNode node17 = new PersonNode(17, "扬志", "青面兽");
        PersonNode node18 = new PersonNode(18, "徐宁", "金枪手");
        PersonNode node19 = new PersonNode(19, "索超", "急先锋");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        singleLinkedList.add(node1);
//        singleLinkedList.add(node2);
//        singleLinkedList.add(node3);
//        singleLinkedList.add(node4);
//        singleLinkedList.add(node5);
//        singleLinkedList.add(node6);
//        singleLinkedList.add(node7);
//        singleLinkedList.add(node8);
//        singleLinkedList.add(node9);
//        singleLinkedList.add(node10);
//        singleLinkedList.add(node11);
//        singleLinkedList.add(node12);
//        singleLinkedList.add(node13);
//        singleLinkedList.add(node14);
//        singleLinkedList.add(node15);
//        singleLinkedList.add(node16);
//        singleLinkedList.add(node17);
//        singleLinkedList.add(node18);
//        singleLinkedList.add(node19);

        singleLinkedList.optiAdd(node1);
        singleLinkedList.optiAdd(node2);
        singleLinkedList.optiAdd(node7);
        singleLinkedList.optiAdd(node8);
        singleLinkedList.optiAdd(node9);
        singleLinkedList.optiAdd(node13);
        singleLinkedList.optiAdd(node10);
        singleLinkedList.optiAdd(node15);
        singleLinkedList.optiAdd(node16);
        singleLinkedList.optiAdd(node6);
        singleLinkedList.optiAdd(node19);
        singleLinkedList.optiAdd(node17);
        singleLinkedList.optiAdd(node14);
        singleLinkedList.optiAdd(node11);
        singleLinkedList.optiAdd(node12);
        singleLinkedList.optiAdd(node3);
        singleLinkedList.optiAdd(node4);
        singleLinkedList.optiAdd(node5);
        singleLinkedList.optiAdd(node18);

        System.out.println("********************************************");
        //显示
        singleLinkedList.list();

        System.out.println("********************************************");
        //测试修改节点的代码
        PersonNode personNode = new PersonNode(19, "Carl", "SS");
        singleLinkedList.update(personNode);
        //显示
        singleLinkedList.list();

        System.out.println("********************************************");
        //删除一个节点
        singleLinkedList.del(19);
        singleLinkedList.del(18);
        singleLinkedList.list();

        System.out.println("有效节点个数：" + SingleLinkedListTest.getLength(singleLinkedList.getHead()));

        System.out.println("********************************************");
        //测试查找倒数第k个节点
        PersonNode test = findLastNode(singleLinkedList.getHead(), 5);
        System.out.println(test);

        System.out.println("********************************************");
        //反转链表
        reverseNode(singleLinkedList.getHead());
        singleLinkedList.list();

        //测试逆序打印单链表
        System.out.println("********************************************");
        System.out.println("测试逆序打印单链表");
        reversePrint(singleLinkedList.getHead());


    }

    //方法：获取单链表的节点的个数(如果时代头节点的链表要将头节点忽略)
    //通过输入头节点来获取链表有效节点的个数
    public static int getLength(PersonNode head){
        if (head.next == null) {    //空链表
            return 0;
        } else {
            int count = 0;
            PersonNode temp = head.next;
            //此时未统计头节点
            while (temp != null) {
                count++;
                temp = temp.next;
            }
            return count;
        }
    }

    //查找单链表中的倒数第k个节点
    //思路：
    //1. 编写一个方法，接收head节点，同时接收一个index(表示倒数第index个节点)
    //2. 先把链表从头到尾遍历，得到一个链表的总的长度(下面的getLength可以实现)
    //3. 得到size后，从链表的第一个开始遍历(size-index)个，就得到结果了
    public static PersonNode findLastNode(PersonNode head, int index) {
        //判断链表是否为空，若为空，则返回null
        if (head.next == null) {
            return null;
        } else {
            //第一次遍历，得到链表的长度
            int length = getLength(head);
            //第二次遍历size-length位置，即为倒数第k个节点
            //先做一个index校验
            if (index <= 0 || index > length) {
                return null;
            } else {
                //定义一个辅助变量
                PersonNode temp = head.next;
                //使用for循环定位到倒数的index
                for (int i = 0; i < length - index; i++) {
                    temp = temp.next;
                }
                return temp;
            }
        }
    }

    //单链表反转
    public static void reverseNode(PersonNode head){
        //若链表为空，则直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }
        //定义一个辅助的指针，辅助遍历原链表
        PersonNode temp = head.next;
        PersonNode next = null; //指向当前节点(temp)的下一个节点
        PersonNode reverseHead = new PersonNode(0, "", "");
        //遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead的最前端
        while (temp != null) {
            next = temp.next;   //保存当前节点的下一个节点
            temp.next = reverseHead.next;   //将temp的下一个节点指向新的链表的最前端
            reverseHead.next = temp;    //将temp连接到新的链表上
            temp = next;    //让temp后移
        }
        //将head.next指向reverseHead.next，实现单链表的反转
        head.next = reverseHead.next;
    }

    //将链表逆序打印，但不破坏链表原有结构
    public static void reversePrint(PersonNode head){
        if (head.next == null) {
            return; //空列表
        }
        //创建一个栈，将各个节点压入栈中
        Stack<PersonNode> stack = new Stack<>();
        PersonNode temp = head.next;
        //将链表的所有节点压入栈
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;   //后移
        }
        //将栈中的节点进行打印
        while (stack.size() > 0) {
            System.out.println(stack.pop());    //栈的特点：先进后出
        }
    }
}

//定义StringLinkedList管理人物
class SingleLinkedList{
    //先初始化头节点，头节点不能修改，并且不存放具体的数据
    private PersonNode head = new PersonNode(0, "", "");

    public PersonNode getHead(){
        return head;
    }

    //添加节点到单向链表
    //思路：当不考虑编号顺序时
    //1. 找到当前链表的最后节点
    //2. 将最后这个节点的next指向新的节点
    public void add(PersonNode personNode) {
        //因为head节点不能移动，因此需要一个辅助变量遍历temp
        PersonNode temp = head;
        //遍历链表，找到末尾元素
        while (true) {
            //找到链表末尾
            if (temp.next == null) {
                break;
            }
            //如果没有找到，就将temp后移至下一个链表元素
            temp = temp.next;
        }
        //直到退出while循环时，此时的temp就指向链表的最末元素
        //将最末节点的next指向一个全新的节点
        temp.next = personNode;
    }

    //第二种添加方式：在添加人物时，根据排名插入到指定的位置
    //如果有这个排名，则显示添加失败，给出提示
    public void optiAdd(PersonNode personNode){
        //因为头节点无法移动，因此仍通过中间变量实现查找添加位置
        //因为是一个单链表，因此找到的temp位于添加位置的前一个节点，否则无法插入
        PersonNode temp = head;
        boolean flag = false;   //标识添加的标号是否存在，默认为false
        while(true) {
            if (temp.next == null) {    //说明已经到达链表末端
                break;
            }
            if (temp.next.no > personNode.no) {  //位置找到，在temp的后面插入
                break;
            } else if (temp.next.no == personNode.no) { //说明正在添加的编号已存在
                flag = true;    //说明编号存在
                break;
            }
            temp = temp.next;   //后移，继续遍历
        }
        //判断flag的值
        if (flag) { //编号存在，不能添加
            System.out.printf("准备插入的人物编号%d已经存在，无法加入\n", personNode.no);
        } else {
            //成功插入
            personNode.next = temp.next;
            temp.next = personNode;
        }
    }

    //修改节点的信息，根据no编号来修改，即no编号不能改
    //说明
    //1. 根据personNode的no修改即可
    public void update(PersonNode personNode) {
        //判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点，根据no编号
        //定义一个中间变量
        PersonNode temp = head;
        boolean flag = false;   //表示是否找到该节点
        while (true) {
            if (temp == null) {
                break;  //已经到了链表的结尾
            }
            if (temp.no == personNode.no) {
                //找到了该节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到要修改的节点
        if (flag) {
            temp.name = personNode.name;
            temp.nickname = personNode.nickname;
        } else {    //未找到该节点信息
            System.out.printf("未能找到编号为%d的节点，无法修改\n",personNode.no);
        }
    }

    //删除节点
    //思路：
    //1. 同样的，head不能移动，因此需要一个temp辅助节点找到待删除节点的前一个节点
    //2. 在比较时，temp.next.no和需要删除的节点的no比较
    public void del(int no) {
        PersonNode temp = head;
        boolean flag = false;   //标识是否找到待删除节点的前一个节点
        while (true) {
            if (temp.next == null) {    //已经到达链表末尾
                break;
            }
            if (temp.next.no == no) {
                //找到了待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag == false) {    //未找到
            System.out.printf("未找到%d节点\n", no);
        }
        temp.next = temp.next.next;
    }

    //显示链表(遍历)
    public void list(){
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        } else {
            //因为头节点无法移动，因此需要同样使用一个中间变量代替其遍历
            PersonNode temp = head.next;
            while (true) {
                //判断是否到链表最后
                if (temp == null) {
                    break;
                }
                //输出节点信息
                System.out.println(temp);
                //将temp后移
                temp = temp.next;
            }
        }
    }
}

//定义一个PersonNode，每一个PersonNode对象就是一个节点
class PersonNode{
    public int no;
    public String name;
    public String nickname;
    public PersonNode next; //指向下一个节点

    public PersonNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    //为了显示方便，重写toString
    @Override
    public String toString() {
        return "PersonNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
