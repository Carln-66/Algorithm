package LeetCodeTest.offer.array;

import java.util.Arrays;

/**
 * @Auther: Carl
 * @Date: 2021/04/17/19:11
 * @Description:    #40 最小的k个数
 */
public class offer_40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }
}
