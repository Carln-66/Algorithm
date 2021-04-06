package LeetCodeTest.offer.linkedlist;

import java.util.List;
import java.util.Stack;

/**
 * @Auther: Carl
 * @Date: 2021/04/06/20:02
 * @Description: 剑指 #06  倒序打印链表
 */
public class offer_06 {

    //链表反转
    public int[] reversePrint(ListNode head) {
        if (head == null) return new int[]{};
        if (head.next == null) return new int[]{head.val};
        ListNode list = reverseList(head);
        ListNode temp = list;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        temp = list;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = temp.val;
            temp = temp.next;
        }
        return arr;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nextNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return nextNode;
    }

    //栈
    public int[] reversePrint1(ListNode head) {
        if (head == null) return new int[]{};
        ListNode temp = head;
        Stack<Integer> stack = new Stack<>();

        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }
        int[] arr = new int[stack.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
        return arr;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}