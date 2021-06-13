package linkedlist;

/**
 * @Auther: Carl
 * @Date: 2021/05/18/12:28
 * @Description: K 个一组翻转链表
 */
public class LeetCode_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }
        ListNode newHead = reverse(head, tail);
        head.next = reverseKGroup(tail, k);
        return newHead;
    }

    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != tail) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    //以下是不足k个也要反转的情况
    public ListNode reverseKGroup1(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if (tail == null) {
                return reverse1(head, tail);
            }
            tail = tail.next;
        }
        ListNode newHead = reverse1(head, tail);
        head.next = reverseKGroup1(tail, k);
        return newHead;
    }

    private ListNode reverse1(ListNode head, ListNode tail) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != tail) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}
