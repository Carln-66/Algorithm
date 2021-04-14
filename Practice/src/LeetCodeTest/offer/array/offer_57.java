package LeetCodeTest.offer.array;

/**
 * @Auther: Carl
 * @Date: 2021/04/14/17:34
 * @Description: #57    和为s的两个数字
 */
public class offer_57 {
    //采用双指针法
    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) left++;
            else if (sum > target) right--;
            else return new int[]{nums[left], nums[right]};
        }
        return new int[]{};
    }
}
