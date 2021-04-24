package offer;

/**
 * @Auther: Carl
 * @Date: 2021/04/24/18:37
 * @Description:    #61 扑克牌中的顺子
 */
public class offer_61 {
    public boolean isStraight(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int index = i - 1;
            int value = nums[i];
            while (index >= 0 && value < nums[index]) {
                nums[index + 1] = nums[index];
                index--;
            }
            nums[index + 1] = value;
        }
        int index = 0;
        for (int i = 0; i < 4; i++) {
            if (nums[i] == 0) {
                index++;
            } else if (nums[i + 1] == nums[i]) {
                return false;
            }
        }
        return nums[4] - nums[index] + 1 <= 5;
    }
}
