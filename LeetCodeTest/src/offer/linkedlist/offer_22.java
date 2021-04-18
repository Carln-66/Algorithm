package offer.linkedlist;

/**
 * @Auther: Carl
 * @Date: 2021/04/11/22:01
 * @Description:  #22 链表中倒数第k个节点
 */
public class offer_22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        int len = 0;
        while (temp.next != null) {
            len++;
            temp = temp.next;
        }
        for (int count = len - k + 1; count > 0; count--){
            head = head.next;
        }
        return head;
    }
}
