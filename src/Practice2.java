import java.util.*;

/**
 * @Auther: Carl
 * @Date: 2021/06/02/13:10
 * @Description:
 */
public class Practice2 {

    public static void main(String[] args) {
        String s = "dvdf";
        lengthOfLongestSubstring(s);
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {i, map.get(target - nums[i])};
            }else {
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }

    public static String longestPalindrome(String s) {
        if (s.length() < 1) {
            return "";
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int odd = expandAroundCentre(s, i, i);
            int even = expandAroundCentre(s, i, i + 1);
            int len = Math.max(odd, even);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end);
    }

    private static int expandAroundCentre(String s, int left, int right) {
        while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;
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
        if (carry > 0) {
            temp.next = new ListNode(1);
        }
        return head.next;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
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

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int len = s.length();
        int res = 0;
        int start = 0;
        for (int end = 0; end < len; end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c) + 1);
            }
            res = Math.max(res, end - start + 1);
            map.put(s.charAt(end), end);
        }
        return res;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        for (int num : nums) {
            cur.add(num);
        }
        int length = nums.length;
        dfs(res, cur, 0, length);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> cur, int first, int length) {
        if (first == length) {
            res.add(new ArrayList<>(cur));
        }
        for (int i = first; i < length; i++) {
            Collections.swap(cur, first, i);
            dfs(res, cur, first + 1, length);
            Collections.swap(cur, first, i);
        }
    }

}
