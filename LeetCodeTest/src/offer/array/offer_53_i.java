package offer.array;

/**
 * @Auther: Carl
 * @Date: 2021/04/03/19:00
 * @Description: 剑指offer #53-i   在排序数组中查找数字
 */
public class offer_53_i {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 5, 5};
        offer_53_i i = new offer_53_i();
        System.out.println(i.search(nums, 5));
    }

    //采用二分递归法
    int count = 0;
    public int search(int[] nums, int target) {
        helper(nums, target, 0, nums.length - 1);
        return count;
    }

    public void helper(int[] nums, int target, int low, int high) {
        if (low <= high) {
            int mid = (high - low) / 2 + low;
            if (low <= high) {
                if (nums[mid] == target) {
                    count++;
                    helper(nums, target, low, mid - 1);
                    helper(nums, target, mid + 1, high);
                } else if (target < nums[mid]) {
                    helper(nums, target, low, mid - 1);
                } else {
                    helper(nums, target, mid + 1, high);
                }
            }
        }
    }

    //两次二分
    public int search1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        int ptrR = left;
        if (right >= 0 && nums[right] != target) {
            return 0;
        }
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        int ptrL = right;
        return ptrR - ptrL - 1;
    }
}
