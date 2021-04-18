package linkedlist;

import org.junit.Test;

/**
 * @Auther: Carl
 * @Date: 2021/04/01/20:30
 * @Description:  LeetCode #61 旋转链表
 */
public class LeetCode_61 {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {    //链表中无节点或者是链表中只有一个节点直接返回
            return head;
        }
        ListNode pointer = head;    //指针指向头节点
        int count = 1;          //count为链表长度，由于遍历链表始终会得到链表长度-1，所以count初始值设置为1
        while (pointer.next != null) {      //退出循环时count为链表长度
            pointer = pointer.next;
            count++;
        }
        int endCount = count - k % count;   //通过该算式得到经过k次旋转后链表的末尾元素位置（从1开始）
        pointer.next = head;        //将链表首尾相接，称为闭环
        while (endCount-- > 0) {    //循环将指针指向旋转后最后一个节点位置
            pointer = pointer.next;
        }
        ListNode res = pointer.next;    //在当前位置的下一个位置开始新建一个链表作为返回链表的头节点，因为当前节点是结尾，需要指向null
        pointer.next = null;    //将当前节点指向null，解除环形。
        return res;
    }

}
