import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: Carl
 * @Date: 2021/06/06/9:38
 * @Description:
 */
public class Practice3 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int fast = 1;
        int slow = 0;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];

            }
            fast++;
        }
        return slow + 1;
    }
}
