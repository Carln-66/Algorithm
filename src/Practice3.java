import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Auther: Carl
 * @Date: 2021/06/06/9:38
 * @Description:
 */
public class Practice3 {
    public int[] singleNumbers(int[] nums) {
        int k = 0;
        for (int num : nums) {
            k ^= num;
        }
        int mask = 1;
        while ((mask & k) == 0) {
            mask <<= 1;
        }
        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((mask & num) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}
