package LeetCodeTest.linkedlist;

import org.junit.Test;

/**
 * @Auther: Carl
 * @Date: 2021/03/30/23:41
 * @Description: LeetCode #2 两数相加
 */
public class LeetCode_2 {

    @Test
    public void test() {

        ListNode listNode1 = new ListNode(9);
        ListNode listNode2 = new ListNode(9);
        ListNode listNode3 = new ListNode(9);
        listNode1.add(listNode2);
        listNode1.add(listNode3);

        ListNode listNode4 = new ListNode(9);
        ListNode listNode5 = new ListNode(9);
        ListNode listNode6 = new ListNode(9);
        listNode4.add(listNode4);
        listNode4.add(listNode5);
        listNode4.add(listNode6);

        addTwoNumbers(listNode1, listNode4).list();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum > 9 ? 1 : 0;
            sum = sum % 10;
            temp.next = new ListNode(sum);

            temp = temp.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry == 1) {
            temp.next = new ListNode(1);
        }
        return head.next;
    }
}

//定义一个PersonNode，每一个PersonNode对象就是一个节点
class ListNode {
    int val;
    ListNode next;
    ListNode head = new ListNode();


    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void list() {
        ListNode temp = head;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public void add(ListNode listNode) {
        while (true) {
            if (listNode.next == null) {
                break;
            }
            listNode = listNode.next;
        }
        listNode.next = listNode;
    }
}