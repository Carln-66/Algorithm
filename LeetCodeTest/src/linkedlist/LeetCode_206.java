package linkedlist;

import java.util.List;

/**
 * @Auther: Carl
 * @Date: 2021/03/30/20:08
 * @Description: LeetCode #206 链表反转
 */
public class LeetCode_206 {
    class Solution {
        //利用头插法
        public ListNode reverseList(ListNode head) {
            ListNode pointer = head;
            ListNode reverseListNode = new ListNode(-1);
            while (pointer != null) {
                ListNode nextNode = pointer.next;
                pointer.next = reverseListNode.next;
                reverseListNode.next = pointer;
                pointer = nextNode;
            }
            return reverseListNode.next;
        }

        //利用递归
        public ListNode reverseList2(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode nextNode = reverseList2(head.next);
            head.next.next = head;
            head.next = null;
            return nextNode;
        }

        //双指针迭代
        public ListNode reverseList3(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;
            while (cur != null) {
                ListNode temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;
            }
            return pre;
        }
    }

    public static class ListNode {
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
}
