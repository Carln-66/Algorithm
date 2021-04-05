/**
 * @Auther: Carl
 * @Date: 2021/03/29/18:18
 * @Description:
 */
public class Preview {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int count = 0;
        ListNode temp = head;
        while (temp.next != null) {
            count++;
            temp = temp.next;
        }
        int pos = (count - 1) - k % count;
        temp.next = head;
        ListNode tail = head;
        for (int i = 0; i < pos; i++) {
            tail = tail.next;
            head = tail;
        }
        head = tail.next;
        tail.next = null;
        return head;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}