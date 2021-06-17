public class Main {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode tempHead = head;
        ListNode tempTail = head.next;
        for (int i = 0; i < left - 1; i++) {
            tempHead = tempHead.next;
            tempTail = tempTail.next;
        }
        for (int i = 0; i < right - left; i++) {
            ListNode temp = tempTail.next;
            tempTail.next = tempTail.next.next;
            tempHead.next = temp.next;
            temp.next = tempTail;
        }
        return res.next;
    }
}
