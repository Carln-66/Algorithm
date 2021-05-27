import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @Auther: Carl
 * @Date: 2021/05/25/8:57
 * @Description:
 */
public class Practice {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return next;
    }
    public ListNode reverseList2(ListNode head) {
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

    public int findRepeatNumber(int[] nums) {
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }

    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int len = 0;
        ListNode temp = head;
        while (temp.next != null) {
            len++;
            temp = temp.next;
        }
        for (int i = len - k + 1; i > 0; i--) {
            head = head.next;
        }
        return head;
    }

    char[] chars;
    List<String> res = new ArrayList<>();
    public String[] permutation(String s) {
        chars = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    private void dfs(int level) {
        if (level == chars.length - 1) {
            res.add(String.valueOf(chars));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = level; i < chars.length; i++) {
            if (set.contains(chars[i])) continue;
            set.add(chars[i]);
            swap(i, level);
            dfs(level + 1);
            swap(level, i);
        }
    }

    private void swap(int a, int b) {
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }

    int[] temp, nums;

    public int reversePairs(int[] nums) {
        this.nums = nums;
        temp = new int[nums.length];
        return mergeSort(0, nums.length - 1);
    }

    private int mergeSort(int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = (left + right) / 2;
        int res = mergeSort(left, mid) + mergeSort(mid + 1, right);
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            temp[k] = nums[k];
        }
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                nums[k] = temp[j++];
            } else if (j == right + 1 || temp[i] <= temp[j]) {
                nums[k] = temp[i++];
            } else {
                nums[k] = temp[j++];
                res += mid - i + 1;
            }
        }
        return res;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        while (l2 != null) {
            temp.next = l2;
            l2 = l2.next;
            temp = temp.next;
        }
        while (l1 != null) {
            temp.next = l1;
            l1 = l1.next;
            temp = temp.next;
        }
        return head.next;
    }

    Map<Integer, Integer> map = new HashMap<>();
    int[] preorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recur(0, 0, inorder.length - 1);
    }

    private TreeNode recur(int preRoot, int inLeft, int inRight) {
        if (inLeft > inRight) return null;
        int rootIndex = map.get(preorder[preRoot]);
        TreeNode root = new TreeNode(preorder[preRoot]);
        root.left = recur(preRoot + 1, inLeft, rootIndex - 1);
        root.right = recur(preRoot + (rootIndex - inLeft) + 1, rootIndex + 1, inRight);
        return root;
    }


}

class CQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public CQueue() {
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return -1;
        }
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}
