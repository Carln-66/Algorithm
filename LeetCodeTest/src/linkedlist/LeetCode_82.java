package linkedlist;

import java.util.List;

/**
 * @Auther: Carl
 * @Date: 2021/05/20/13:00
 * @Description: 删除排序链表中的重复元素 II
 */
public class LeetCode_82 {
    public static void main(String[] args) {
        ListNode node7 = new ListNode(5);
        ListNode node6 = new ListNode(4, node7);
        ListNode node5 = new ListNode(4, node6);
        ListNode node4 = new ListNode(3, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        deleteDuplicates(node1);
    }
    public static ListNode deleteDuplicates(ListNode head) {
        //创建一个新的链表头目的是消除链表第一个数就是重复数字的情况
        ListNode newHead = new ListNode(0, head);
        ListNode cur = newHead;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int value = cur.next.val;
                while (cur.next != null && cur.next.val == value) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return newHead.next;
    }
}
