package offer.array;

/**
 * @Auther: Carl
 * @Date: 2021/04/09/22:33
 * @Description: 剑指offer #51  数组中的逆序对
 * 利用分治思想进行归并排序
 */
public class offer_51 {
        public int reversePairs(int[] nums) {
            int len = nums.length;
            if (len < 2) {  //若数组中元素个数为0或1个，直接返回0
                return 0;
            }
            int[] copy = new int[len];  //拷贝nums数组，使所有的操作不改变原有数组的结构
            for (int i = 0; i < len; i++) {
                copy[i] = nums[i];
            }
            int[] temp = new int[len];
            return reverseParis(copy, 0, len - 1, temp);
        }

        public int reverseParis(int[] nums, int left, int right, int[] temp) {
            if (left == right) {    //若左右相等，说明当前数组中只剩一个元素，此时递的过程结束，开始归
                return 0;
            }
            int mid = left + (right - left) / 2;    //用此方法避计算中间值避免了整型溢出的情况
            int leftPairs = reverseParis(nums, left, mid, temp);    //调用递归，向左依次分解字数组计算逆序对个数
            int rightPairs = reverseParis(nums, mid + 1, right, temp);  //调用递归，向右依次分解字数组计算逆序对个数
            if (nums[mid] <= nums[mid + 1]) {   //左数组中的最大元素还小于等于右数组中的最小元素，此时不会产生逆序对，那接合并
                return leftPairs + rightPairs;
            }
            int crossPairs = mergeAndCount(nums, left, mid, right, temp);   //开始进入方法中进行比较
            return leftPairs + rightPairs + crossPairs;
        }

        private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
            for (int i = left; i <= right; i++) {
                temp[i] = nums[i];
            }
            int i = left;   //左子数组的头元素
            int j = mid + 1;    //右子树组的头元素
            int count = 0;  //计数
            for (int k = left; k <= right; k++) {   //从左至右循环，对于不同左右区间的左右子树可以进行不同的计算
                if (i == mid + 1) {     //左子数组长度为0
                    nums[k] = temp[j];
                    j++;
                } else if (j == right + 1) {    //右子树组长度为0
                    nums[k] = temp[i];
                    i++;
                } else if (temp[i] <= temp[j]) {    //左子数组头元素大于右子数组头元素，说明是正序，向下进行
                    nums[k] = temp[i];
                    i++;
                } else {    //右子树组头元素小于左子树组，说明是逆序，计数器累加当前左子树组的元素数量
                    nums[k] = temp[j];
                    j++;
                    count += (mid - i + 1);
                }
            }
            return count;
        }
}
