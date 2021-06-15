package linkedlist;

/**
 * @Auther: Carl
 * @Date: 2021/06/15/7:20
 * @Description: 删除链表中的重复元素
 */
public class LeetCode_83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
