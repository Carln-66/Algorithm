/**
 * @Auther: Carl
 * @Date: 2021/03/29/18:18
 * @Description:
 */
public class Preview {
    public void BubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j + 1] = arr[j];
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
            while (l < r && arr[r] >= pivot) {
                r--;
            }
            if (arr[r] < pivot) {
                arr[l] = arr[r];
            }
            while (l < r && arr[l] <= pivot) {
                l++;
            }
            if (arr[l] > pivot) {
                arr[r] = arr[l];
            }
            if (arr[l] >= arr[r]) {
                arr[l] = pivot;
            }
        }
        quickSort(arr, left, r - 1);
        quickSort(arr, l + 1, right);
    }

    public void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int index = i - 1;
            int value = arr[i];
            while (index >= 0 && arr[index] > value) {
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = value;
        }
    }

    public void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int l = left;
        int r = right;
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
}
