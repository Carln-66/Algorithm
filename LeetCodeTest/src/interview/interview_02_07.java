package interview;

/**
 * @Auther: Carl
 * @Date: 2021/07/21/7:22
 * @Description: 链表相交
 */
public class interview_02_07 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != curB) {
            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
        }
        return curA;
    }
}
