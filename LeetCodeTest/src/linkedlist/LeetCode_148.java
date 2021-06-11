package linkedlist;

import java.util.List;

/**
 * @Auther: Carl
 * @Date: 2021/06/11/13:30
 * @Description: 排序链表
 */
public class LeetCode_148 {
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(temp);
        ListNode h = new ListNode(0);
        merge(h, left, right);
        return h;
    }

    private static void merge(ListNode res, ListNode left, ListNode right) {
        while (left != null && right != null) {
            if (left.val <= right.val) {
                res.next = left;
                left = left.next;
            } else {
                res.next = right;
                right = right.next;
            }
            res = res.next;
        }
        res.next = left != null ? left : right;
    }
}
