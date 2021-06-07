import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Auther: Carl
 * @Date: 2021/06/06/9:38
 * @Description:
 */
public class Practice3 {
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        int left = 0, right = list.size() - 1;
        while (left < right) {
            list.get(left).next = list.get(right);
            left++;
            if (left == right) {
                break;
            }
            list.get(right).next = list.get(left);
            right--;
        }
        list.get(left).next = null;
    }
}
