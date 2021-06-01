package offer.array;

import java.util.ArrayList;

/**
 * @Auther: Carl
 * @Date: 2021/04/23/18:18
 * @Description:    #57-ii  和为s的连续正数序列
 */
public class offer_57_ii {
    //滑动窗口解法
    public int[][] findContinuousSequence(int target) {
        int i = 1;
        int j = 1;
        int sum = 0;
        ArrayList<int[]> res = new ArrayList<>();
        while (i <= target >> 1) {
            if (sum > target) {
                sum -= i;
                i++;
            } else if (sum < target) {
                sum += j;
                j++;
            } else {
                int[] arr = new int[j - i];
                for (int k = i; k < j; k++) {
                    arr[k - i] = k;
                }
                res.add(arr);
                sum -= i;
                i++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
