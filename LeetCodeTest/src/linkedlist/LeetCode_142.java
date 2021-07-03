package linkedlist;

import javax.swing.tree.TreeNode;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Auther: Carl
 * @Date: 2021/06/29/0:44
 * @Description:
 */
public class LeetCode_142 {
    /**
     * 采用快慢指针
     * 快指针走两次，慢指针走一次，两指针相遇停止
     * 定义新的指针temp位置在head，temp和slow同时走，当temp与slow相遇位置就是链表环的出口
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode temp = head;
                while (temp != slow) {
                    temp = temp.next;
                    slow = slow.next;
                }
                return temp;
            }
        }
        return null;
    }

    public ListNode detectCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode temp = head;
        while (temp != null) {
            if (set.contains(temp)) {
                return temp;
            }
            set.add(temp);
            temp = temp.next;
        }
        return null;
    }
}
