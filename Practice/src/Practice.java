import java.util.*;

public class Practice {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(temp);
        ListNode res = new ListNode(0);
        merge(res, l1, l2);
        return res.next;
    }

    private void merge(ListNode res, ListNode left, ListNode right) {
        while (left != null && right != null) {
            if (left.val < right.val) {
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
