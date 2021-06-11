public class Practice3 {
    public int trap(int[] height) {
        int max_left = 0;
        int max_right = 0;
        int left = 1;
        int right = height.length - 2;
        int sum = 0;
        for (int i = 0; i < height.length - 1; i++) {
            if (height[left - 1] < height[right + 1]) {
                max_left = Math.max(height[left - 1], max_left);
                int min = max_left;
                if (min > height[left]) {
                    sum += min - height[left];
                }
                left++;
            } else {
                max_right = Math.max(height[right + 1], max_right);
                int min = max_right;
                if (min > height[right]) {
                    sum += min - height[right];
                }
                right--;
            }
        }
        return sum;
    }
}
