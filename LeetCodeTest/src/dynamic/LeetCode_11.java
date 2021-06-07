package dynamic;

/**
 * @Auther: Carl
 * @Date: 2021/06/07/11:51
 * @Description: 盛水最多的容器
 */
public class LeetCode_11 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int sum = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            sum = Math.max(sum, area);
            if (height[left] < height[right]) {
                ++left;
            } else {
                --right;
            }
        }
        return sum;
    }
}
