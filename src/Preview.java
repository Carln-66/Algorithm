/**
 * @Auther: Carl
 * @Date: 2021/03/29/18:18
 * @Description:
 */
public class Preview {

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
            if (l < r) {
                arr[l] = arr[r];
            }
            while (l < r && arr[l] < pivot) {
                l++;
            }
            if (l < r) {
                arr[r] = arr[l];
            }
            if (l >= r) {
                arr[l] = pivot;
            }
        }
        quickSort(arr, left, r - 1);
        quickSort(arr, l + 1, right);
    }
}
