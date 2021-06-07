package array;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Auther: Carl
 * @Date: 2021/06/07/17:30
 * @Description: 132模式
 * https://leetcode-cn.com/problems/132-pattern/solution/xiang-xin-ke-xue-xi-lie-xiang-jie-wei-he-95gt/
 * 从后往前遍历
 * 单调栈维护的是3，k维护的是2，枚举的是1
 * 如果nums[i]要进栈之前，先和栈顶元素比较一下，如果nums[i]更大，说明栈顶元素（数组中位置相对靠后）比nums[i]（数组中位置靠前）要小一些，这样正好可以作为32的条件，但是如果栈顶元素更大，则说明132中的“2”比“3”更大，显然不行，同时这种情况下无论怎么样都够不成132这样的结构的，所以把当前这个数压进栈里，方便数组前面的数判定谁比他大
 * 对于1的判定非常简单，因为它是最小的数，只要2确定了，同时2比1大，那就就成立
 */
public class LeetCode_456 {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int k = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < k) {
                return true;
            }
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                k = Math.max(k, deque.pollLast());
            }
            deque.add(nums[i]);
        }
        return false;
    }
}
