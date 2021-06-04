/**
 * @Auther: Carl
 * @Date: 2021/06/04/19:51
 * @Description:
 */
public class HeapSortTest {
    public void HeapSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int len = nums.length;
        buildMaxHeap(nums, len);
        for (int i = len - 1; i > 0; i--) {
            swap(nums, 0, i);
            len--;
            heapify(nums, i, len);
        }
    }

    private void buildMaxHeap(int[] nums, int len) {
        for (int i = (int) Math.floor(len / 2) - 1; i >= 0; i--) {
            heapify(nums, i, len);
        }
    }

    private void heapify(int[] nums, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largestIndex = i;
        if (left < len && nums[left] > nums[largestIndex]) {
            largestIndex = left;
        }
        if (right < len && nums[right] > nums[largestIndex]) {
            largestIndex = right;
        }
        if (largestIndex != i) {
            swap(nums, largestIndex, i);
            heapify(nums, largestIndex, len);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
