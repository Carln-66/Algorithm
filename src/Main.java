import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class Main {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        int ptrR = left;
        if (right >= 0 && nums[right] != target) {
            return 0;
        }
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        int ptrL = right;
        return ptrR - ptrL - 1;
    }
}