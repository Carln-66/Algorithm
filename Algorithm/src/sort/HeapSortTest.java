package sort;

/**
 * @Auther: Carl
 * @Date: 2021/06/04/19:18
 * @Description: 堆排序
 */
public class HeapSortTest {
    public void heapSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int len = arr.length;
        buildMaxHeap(arr, len);
        for (int i = len - 1; i > 0; i--) {
            swap(arr, 0, i);
            len--;
            heapify(arr, 0, len);
        }
    }

    private void buildMaxHeap(int[] arr, int len) {
        for (int i = (int) Math.floor(len / 2) - 1; i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    private void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largestIndex = i;
        if (left < len && arr[left] > arr[largestIndex]) {
            largestIndex = left;
        }
        if (right < len && arr[right] > arr[largestIndex]) {
            largestIndex = right;
        }
        if (largestIndex != i) {
            swap(arr, i, largestIndex);
            heapify(arr, largestIndex, len);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
