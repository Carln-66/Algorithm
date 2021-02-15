/**
 * @Auther: Carl
 * @Date: 2021/02/15/7:53
 * @Description:
 * 给定n个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 * 输入：[1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 */
public class MaxSubArrayAverNum {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = new int[]{1,12,-5,-6,50,3};
        double maxAverage = solution.findMaxAverage(array, 4);
        System.out.println(maxAverage);
    }
}

/*
滑动窗口类型
以k为长度取子数组，然后窗口依次右移，将新的窗口和赋给sum，顺次递增，利用Math.max(int a, int b)方法进行maxSum与sum的比较取出最大和。
 */
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int i = k; i < nums.length; i++) {
            sum = sum -nums[i - k] + nums[i];
            maxSum = Math.max(sum, maxSum);
        }
        return 1.0 * maxSum / k;
    }
}