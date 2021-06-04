/**
 * @Auther: Carl
 * @Date: 2021/03/29/18:18
 * @Description:
 */
public class Preview {
    public void BubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }
    public void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int l = left;
        int r = right;
        int pivot = arr[l];
        while (l < r) {
            while (l < r && arr[r] > pivot) {
                r--;
            }
            if (arr[r] < pivot) {
                arr[l] = arr[r];
            }
            while (l < r && arr[l] < pivot) {
                l++;
            }
            if (arr[l] > pivot) {
                arr[r] = arr[l];
            }
            if (l >= r) {
                arr[l] = pivot;
            }
        }
        quickSort(arr, left, r - 1);
        quickSort(arr, l + 1, right);
    }

    public void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int index = i;
            int value = arr[i];
            while (index >= 0 && arr[index] > value) {
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = value;
        }
    }

    public void mergeSort(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int l = 0;
        int r = mid + 1;
        int[] temp = new int[right - left + 1];
        int k = 0;
        while (l <= mid && r <= right) {
            if (arr[l] < arr[r]) {
                temp[k++] = arr[l++];
            } else {
                temp[k++] = arr[r++];
            }
        }
        while (l <= mid) {
            temp[k++] = arr[l++];
        }
        while (r <= right) {
            temp[k++] = arr[r++];
        }
        for (int i = 0; i < temp.length; i++) {
            arr[i + left] = temp[i];
        }

    }

    public void shellSort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = 0; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                while (j - gap > 0 && temp < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j -= i;
                }
                arr[j] = temp;
            }
        }
    }

    public void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    index = j;
                }
            }
            if (index != i) {
                arr[index] = arr[i];
                arr[i] = min;
            }
        }
    }

    public void HeapSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int len = arr.length;;
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
