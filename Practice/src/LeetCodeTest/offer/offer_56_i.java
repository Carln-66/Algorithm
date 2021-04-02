package LeetCodeTest.offer;

/**
 * @Auther: Carl
 * @Date: 2021/04/03/0:09
 * @Description: 力扣剑指offer #56-i  数组中数字出现的次数
 */
public class offer_56_i {

    public int[] singleNumbers(int[] nums) {
        int k = 0;
        for (int num : nums) {
            k ^= num;
        }
        int mask = 1;   //0001
        while ((k & mask) == 0) {
            mask <<= 1;
        }
        int a = 0;
        int b = 0;

        for (int num : nums) {
            if ((num & mask) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}
