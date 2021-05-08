package linkedlist;

/**
 * @Auther: Carl
 * @Date: 2021/05/08/17:50
 * @Description:    反转链表II
 */
public class LeetCode_92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;

        ListNode p = newHead;
        ListNode q = newHead.next;

        for (int i = 0; i < left - 1; i++) {
            p = p.next;
            q = q.next;
        }

        for (int i = 0; i < right - left; i++) {
            ListNode temp = q.next;
            q.next = temp.next;
            temp.next = p.next;
            p.next = temp;
        }
        return newHead.next;
    }
}
