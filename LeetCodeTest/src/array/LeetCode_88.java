package array;

/**
 * @Auther: Carl
 * @Date: 2021/05/07/21:33
 * @Description: 合并两个有序数组
 */
public class LeetCode_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m + n];
        int cur = 0;
        int temp1 = 0;
        int temp2 = 0;
        while (temp1 < m || temp2 < n) {
            if (temp1 == m) {
                cur = nums2[temp2++];
            } else if (temp2 == n) {
                cur = nums1[temp1++];
            } else if (nums1[temp1] < nums2[temp2]) {
                cur = nums1[temp1];
                temp1++;
            } else {
                cur = nums2[temp2];
                temp2++;
            }
            res[temp1 + temp2 - 1] = cur;
        }
        if (m + n >= 0) System.arraycopy(res, 0, nums1, 0, m + n);
    }
}
