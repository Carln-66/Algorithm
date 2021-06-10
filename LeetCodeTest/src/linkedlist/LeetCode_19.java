package linkedlist;

/**
 * @Auther: Carl
 * @Date: 2021/06/10/17:18
 * @Description: 删除链表的倒数第 N 个结点
 */
public class LeetCode_19 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        if (count == n) {
            head = head.next;
        }
        temp = head;
        for (int i = 0; i < count - n - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
}
