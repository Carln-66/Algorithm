package offer.array;

/**
 * @Auther: Carl
 * @Date: 2021/04/02/22:22
 * @Description: 力扣剑指offer  #03  数组中重复的数字
 */
public class offer_03 {
    //原地交换的思想
    public int findRepeatNumber(int[] nums) {
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }
}
