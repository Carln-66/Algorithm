package offer.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Carl
 * @Date: 2021/06/01/14:32
 * @Description: 数组中出现次数超过一半的数字
 * https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/solution/mian-shi-ti-39-shu-zu-zhong-chu-xian-ci-shu-chao-3/
 */
public class offer_39 {
    //摩尔投票法
    public int majorityElement(int[] nums) {
        int vote = 0, x = 0;
        for (int num : nums) {
            if (vote == 0) x = num;
            vote += num == x ? 1 : -1;
        }
        return x;
    }
}
