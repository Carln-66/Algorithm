//zhuhaishen@jd.com
//贺梓毓
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 1, 4, 4, 6};
        int[] nums1 = {1, 4, 4, 5, 5};
        int[] nums2 = {1, 1, 8, 9, 9, 14, 14};
        int[] nums3 = {2};
        int[] nums4 = {3, 3, 4, 4, 5};
        int[] nums5 = {1, 1, 2};
        int[] nums6 = {-9, -9, -2, -1, -1};
        int[] nums7 = {-9, -9, -3, -3, 0, 1, 1, 2, 2};
        System.out.println("期望结果：6，输出结果：" + findNum(nums));
        System.out.println("期望结果：1，输出结果：" + findNum(nums1));
        System.out.println("期望结果：8，输出结果：" + findNum(nums2));
        System.out.println("期望结果：2，输出结果：" + findNum(nums3));
        System.out.println("期望结果：5，输出结果：" + findNum(nums4));
        System.out.println("期望结果：2，输出结果：" + findNum(nums5));
        System.out.println("期望结果：-2，输出结果：" + findNum(nums6));
        System.out.println("期望结果：0，输出结果：" + findNum(nums7));
    }

    //二分法求解
    public static int findNum(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }
            if (mid % 2 == 0) {
                if (nums[mid] == nums[mid + 1]) {
                    left = mid;
                } else {
                    right = mid;
                }
            } else {
                if (nums[mid] == nums[mid - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return nums[left];
    }
}
