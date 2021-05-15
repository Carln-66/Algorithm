package linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Carl
 * @Date: 2021/05/15/20:12
 * @Description: 重排链表
 */
public class LeetCode_143 {
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head.next != null) {
            list.add(head);
            head = head.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }
}
