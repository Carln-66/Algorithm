/**
 * @Auther: Carl
 * @Date: 2021/06/14/12:38
 * @Description:
 */
public class SortPractice {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, 1, -5, 3, 9, 4};
        mergeSort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean flag = true;
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j + 1] < nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    public static void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int index = i - 1;
            int value = nums[i];
            while (index >= 0 && value < nums[index]) {
                nums[index + 1] = nums[index];
                index--;
            }
            nums[index + 1] = value;
        }
    }

    public static void selectSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = i;
            int value = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < value) {
                    value = nums[j];
                    index = j;
                }
            }
            if (index != i) {
                nums[index] = nums[i];
                nums[i] = value;
            }
        }
    }

    public static void shellSort(int[] nums) {
        for (int gap = nums.length / 2; gap > 0; gap /= 2) {
            for (int i = 0; i < nums.length; i++) {
                int index = i;
                int temp = nums[i];
                while (index - gap >= 0 && temp < nums[index - gap]) {
                    nums[index] = nums[index - gap];
                    index = index - gap;
                }
                nums[index] = temp;
            }
        }
    }

    public static void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }

    private static void merge(int[] nums, int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int[] temp = new int[right - left + 1];
        int k = 0;
        while (l <= mid && r <= right) {
            if (nums[l] < nums[r]) {
                temp[k++] = nums[l++];
            } else {
                temp[k++] = nums[r++];
            }
        }
        while (l <= mid) {
            temp[k++] = nums[l++];
        }
        while (r <= right) {
            temp[k++] = nums[r++];
        }
        for (int i = 0; i < temp.length; i++) {
            nums[left + i] = temp[i];
        }
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left > right) {
            return;
        }
        int l = left;
        int r= right;
        int pivot = nums[l];
        while (l < r) {
            while (l < r && nums[r] >= pivot) {
                r--;
            }
            if (l < r) {
                nums[l] = nums[r];
            }
            while (l < r && nums[l] <= pivot) {
                l++;
            }
            if (l < r) {
                nums[r] = nums[l];
            }
            if (l >= r) {
                nums[l] = pivot;
            }
        }
        quickSort(nums, l + 1, right);
        quickSort(nums, left, r - 1);
    }

    public static void heapSort(int[] nums) {
        if (nums.length == 0 || nums == null) return;
        int len = nums.length;
        buildHeap(nums, len);
        for (int i = len- 1; i > 0; i--) {
            swap(nums, 0, i);
            len--;
            heapify(nums, len, 0);
        }
    }

    private static void buildHeap(int[] nums, int len) {
        for (int i = (int) Math.floor(len / 2) - 1; i >= 0; i--) {
            heapify(nums, len, i);
        }
    }

    private static void heapify(int[] nums, int len, int i) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int maxIndex = i;
        if (left < len && nums[left] > nums[maxIndex]) {
            maxIndex = left;
        }
        if (right < len && nums[right] > nums[maxIndex]) {
            maxIndex = right;
        }
        if (maxIndex != i) {
            swap(nums, i, maxIndex);
            heapify(nums, len, maxIndex);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
