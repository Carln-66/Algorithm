package array;

/**
 * @Auther: Carl
 * @Date: 2021/05/10/18:51
 * @Description: 寻找两个正序数组的中位数
 */
public class LeetCode_4 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{0};
        int[] arr2 = new int[]{-1, 0, 1};

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int temp1 = 0;
        int temp2 = 0;
        int k = 0;
        int len = nums1.length + nums2.length;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            if (temp1 < nums1.length && temp2 < nums2.length && nums1[temp1] < nums2[temp2]) {
                arr[i] = nums1[temp1];
                temp1++;
            } else if (temp1 < nums1.length && temp2 < nums2.length && nums1[temp1] >= nums2[temp2]) {
                arr[i] = nums2[temp2];
                temp2++;
            } else {
                k = i;
                break;
            }
        }
        while (temp1 < nums1.length) {
            arr[k++] = nums1[temp1++];
        }
        while (temp2 < nums2.length) {
            arr[k++] = nums2[temp2++];
        }
        if (arr.length % 2 == 0) {
            return (double) (arr[arr.length / 2 - 1] + arr[arr.length / 2]) / 2;
        } else {
            return arr[arr.length / 2];
        }
    }
}
