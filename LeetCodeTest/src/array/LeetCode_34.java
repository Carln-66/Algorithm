package array;

/**
 * @Auther: Carl
 * @Date: 2021/06/19/17:35
 * @Description: 在排序数组中查找元素的第一个和最后一个位置
 */
public class LeetCode_34 {
    //借助二分查找
    public int[] searchRange(int[] nums, int target) {
        //target - 1定位到当前target的前一个位置，由于二分判断条件为left <= right，所以结束循环之后right会在left的左边，需要定位到left的位置才是数组中target第一次出现的位置。
        int leftIdx = binarySearch(nums, target - 1);
        //整体二分后减一因为传入的是target，结束循环返回后会定位到当前数组target最后一次出现位置的后一个数，所以将索引减一
        int rightIdx = binarySearch(nums, target) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    //此方法求的是第一个大于target的数的下标
    //如果输入的是target - 1那么找到的就是target第一次出现的位置
    //如果输入的是target，那么找到的就是target最后一次出现位置的后一个位置，然后进行减一即可
    private int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int res = nums.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            //将从0 ~ mid - 1查找，每次需要进行记录保证下次循环不会出现left>right直接退出的情况
            if (target < nums[mid]) {
                right = mid - 1;
                res = mid;
            } else {    //如果target >= nums[mid] 将范围转换至mid + 1 ~ right
                left = mid + 1;
            }
        }
        return res;
    }
}
