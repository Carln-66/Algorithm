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
        ListNode newHead = reverseList(head, tail);
        reverseKGroup(tail, k);
        return newHead;
    }

    private ListNode reverseList(ListNode head, ListNode tail) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != tail) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
