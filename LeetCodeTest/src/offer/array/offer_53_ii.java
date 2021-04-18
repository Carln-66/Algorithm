package offer.array;

/**
 * @Auther: Carl
 * @Date: 2021/04/03/21:07
 * @Description:  剑指offer #53-ii  0～n-1中缺失的数字
 */
public class offer_53_ii {
    public int missingNumber(int[] nums) {
        int left = 0, right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) >> 1;
            if (mid == nums[mid]){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
