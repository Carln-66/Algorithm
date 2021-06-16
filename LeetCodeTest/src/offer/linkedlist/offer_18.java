package offer.linkedlist;

/**
 * @Auther: Carl
 * @Date: 2021/06/15/20:38
 * @Description: 删除链表的节点
 */
public class offer_18 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) return head.next;
        ListNode temp = head;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        return head;
    }
}
