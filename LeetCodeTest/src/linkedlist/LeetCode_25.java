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
                return null;
            }
            tail = tail.next;
        }
        ListNode newHead = reverser(head, tail);
        head.next = reverseKGroup(tail, k);
        return newHead;
    }

    private ListNode reverser(ListNode head, ListNode tail) {
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
