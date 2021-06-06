package linkedlist;

/**
 * @Auther: Carl
 * @Date: 2021/03/31/21:01
 * @Description: LeetCode #23 合并k个有序链表
 */
public class LeetCode_23 {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for (int i = 0; i < lists.length; i++) {
            ans = mergeTwoLists(ans, lists[i]);     //i叠加，每次调用不同的数进行插入排序
        }
        return ans;
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {     //考虑中间是否有空链表存在
            return l1 == null ? l2 : l1;
        }
        ListNode head = new ListNode(-1);
        ListNode pointer = head;
        ListNode aPointer = l1; //l1链表向后遍历指针
        ListNode bPointer = l2; //l2链表向后遍历指针
        //进行双链表排序
        while (aPointer != null && bPointer != null) {
            if (aPointer.val <= bPointer.val) {
                pointer.next = aPointer;
                aPointer = aPointer.next;
            } else {
                pointer.next = bPointer;
                bPointer = bPointer.next;
            }
            pointer = pointer.next;
        }
        pointer.next = aPointer == null ? bPointer : aPointer;
        return head.next;
    }

    public ListNode mergeKLists1(ListNode[] lists) {
        return merge1(lists, 0, lists.length - 1);
    }

    private ListNode merge1(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        if (lists == null) {
            return null;
        }
        int mid = (left + right) >> 1;
        return mergeTwoLists(merge1(lists, left, mid), merge1(lists, mid + 1, right));
    }

    private ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        ListNode node1 = l1;
        ListNode node2 = l2;
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
