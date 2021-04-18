package offer.array;

/**
 * @Auther: Carl
 * @Date: 2021/04/13/22:31
 * @Description: #11    旋转数组中的最小数字
 */
public class offer_11 {
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left != right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return numbers[left];
    }
}
