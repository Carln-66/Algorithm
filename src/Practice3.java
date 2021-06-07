/**
 * @Auther: Carl
 * @Date: 2021/06/06/9:38
 * @Description:
 */
public class Practice3 {
    public int trap(int[] height) {
        int sum = 0;
        int left_max = 0;
        int right_max = 0;
        int left = 1;
        int right = height.length - 2;
        for (int i = 1; i < height.length - 1; i++) {
            if (height[left - 1] < height[right + 1]) {
                left_max = Math.max(left_max, height[left - 1]);
                int min = left_max;
                if (min > height[left]) {
                    sum += min - height[left];
                }
                left++;
            } else {
                right_max = Math.max(right_max, height[right + 1]);
                int min = right_max;
                if (min > height[right]) {
                    sum += min - height[right];
                }
                right--;
            }
        }
        return sum;
    }
}
