import java.util.*;

public class Practice {

    public boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        }
        int maxPos = 0;
        for (int i = 0; i <= maxPos; i++) {
            int temp = nums[i] + i;
            maxPos = Math.max(temp, maxPos);
            if (maxPos >= nums.length - 1) return true;
        }
        return false;
    }
}
