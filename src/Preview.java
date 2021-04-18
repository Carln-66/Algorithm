/**
 * @Auther: Carl
 * @Date: 2021/03/29/18:18
 * @Description:
 */
public class Preview {
    public void BubbleSort(int[] arr) {
        int temp = 0;
        if (arr != null || arr.length > 1) {
            for (int i = 0; i < arr.length - 1; i++) {
                boolean flag = true;
                for (int j = 0; j < arr.length - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        temp = arr[j];
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
            int value = arr[i];
            int index = i - 1;
            while (index >= 0 && value <= arr[index]) {
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index] = value;
        }
    }
}
