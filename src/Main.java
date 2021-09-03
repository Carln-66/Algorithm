import java.util.Stack;

public class Main {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;
        int len = 0;
        while (temp != null) {
            len++;
            stack.push(temp.val);
            temp = temp.next;
        }
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = stack.pop();
        }
        return res;
    }
}