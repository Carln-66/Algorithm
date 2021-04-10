package LeetCodeTest.offer.linkedlist;

/**
 * @Auther: Carl
 * @Date: 2021/04/10/20:15
 * @Description: 剑指offer #52    两个链表的第一个公共点
 */
public class offer_52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA, temp2 = headB;
        while (temp1 != temp2) {
            temp1 = temp1 != null ? temp1.next : headB;
            temp2 = temp2 != null ? temp2.next : headA;
        }
        return temp1;
    }
}
