package others;

/**
 * @Auther: Carl
 * @Date: 2021/06/06/20:33
 * @Description: x的平方根
 */
public class LeetCode_69 {
    public int mySqrt(int x) {
        int left = 0, right = x;
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
