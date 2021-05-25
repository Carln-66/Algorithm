package array;

import java.util.Arrays;

/**
 * @Auther: Carl
 * @Date: 2021/05/25/7:31
 * @Description: 数组中的第K个最大元素
 */
public class LeetCode_215 {
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        int res = 0;
        for (int i = 0; i <= nums.length - k; i++) {
            res = nums[i];
        }
        return res;
    }

    private static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int l = left;
        int r = right;
        int pivot = nums[l];
        while (l < r) {
            while (l < r && nums[r] >= pivot) {
                r--;
            }
            if (nums[r] < pivot) {
                nums[l] = nums[r];
            }
            while (l < r && nums[l] <= pivot) {
                l++;
            }
            if (nums[l] > pivot) {
                nums[r] = nums[l];
            }
            if (l >= r) {
                nums[l] = pivot;
            }
        }
        quickSort(nums, left, r - 1);
        quickSort(nums, l + 1, right);
    }
}
