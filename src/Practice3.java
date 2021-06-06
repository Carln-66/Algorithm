import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: Carl
 * @Date: 2021/06/06/9:38
 * @Description:
 */
public class Practice3 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        ListNode pointer1 = l1;
        ListNode pointer2 = l2;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = l1 != null ? l1 : l2;
        return head.next;
    }
}
