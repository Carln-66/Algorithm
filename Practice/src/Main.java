import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public int[] sortArrayByParity(int[] nums) {
        //采用原地置换
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] % 2 > nums[right] % 2) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            if (nums[left] % 2 == 0) left++;
            if (nums[right] % 2 == 1) right--;
        }
        return nums;
    }
}
