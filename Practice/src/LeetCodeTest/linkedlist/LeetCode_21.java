package LeetCodeTest.linkedlist;

/**
 * @Auther: Carl
 * @Date: 2021/03/31/19:36
 * @Description: LeetCode #21 合并两个有序链表
 */
public class LeetCode_21 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode pointer = head;
        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                pointer.next = l2;
                l2 = l2.next;
            } else {
                pointer.next = l1;
                l1 = l1.next;
            }
            pointer = pointer.next;
        }
        pointer.next = l1 == null ? l2 : l1;
        return head.next;
    }
}
