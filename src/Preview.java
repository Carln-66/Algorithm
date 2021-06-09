/**
 * @Auther: Carl
 * @Date: 2021/03/29/18:18
 * @Description:
 */
public class Preview {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 6, 2, 3, -4, -3};
        heapSort(nums);
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

    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int l = left;
        int r = right;
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
        quickSort(nums, left, r - 1);
        quickSort(nums, l + 1, right);
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

    public static void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = (left + right) >> 1;
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
            if (l < r && nums[l] < nums[r]) {
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

    public static void shellSort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = 0; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                while (j - gap >= 0 && temp < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
        }
    }

    public static void selectSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = nums[i];
            int index = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    index = j;
                }
            }
            if (index != i) {
                nums[index] = nums[i];
                nums[i] = min;
            }
        }
    }

    public static void heapSort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int len = nums.length;
        buildHeap(nums, len);
        for (int i = len - 1; i > 0; i--) {
            swap(nums, 0, i);
            len--;
            heapify(nums, 0, len);
        }
    }

    private static void buildHeap(int[] nums, int len) {
        for (int i = (int) Math.floor(len / 2) - 1; i >= 0; i--) {
            heapify(nums, i, len);
        }
    }

    private static void heapify(int[] nums, int i, int len) {
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
            heapify(nums, maxIndex, len);
        }
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
