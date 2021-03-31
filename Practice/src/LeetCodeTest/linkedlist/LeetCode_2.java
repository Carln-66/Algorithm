package LeetCodeTest.linkedlist;

/**
 * @Auther: Carl
 * @Date: 2021/03/30/23:41
 * @Description: LeetCode #2 两数相加
 */
public class LeetCode_2 {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(7);
        ListNode listNode3 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;

        ListNode listNode4 = new ListNode(9);
        ListNode listNode5 = new ListNode(9);
        ListNode listNode6 = new ListNode(9);

        listNode4.next = listNode5;
        listNode5.next = listNode6;
        ListNodeService listNodeService = new ListNodeService();
        listNodeService.list(LeetCode_2.addTwoNumbers(listNode1, listNode4));

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y +carry;

            carry = sum > 9 ? 1 : 0;
            sum = sum % 10;
            temp.next = new ListNode(sum);

            temp = temp.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry == 1) {
            temp.next = new ListNode(1);
        }
        return head.next;
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
