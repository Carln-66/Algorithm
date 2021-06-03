/**
 * @Auther: Carl
 * @Date: 2021/06/03/13:21
 * @Description: 整数反转
 */
public class LeetCode_7 {
    public int reverse(int x) {
        int res = 0 ;
        while (x != 0) {
            int temp = x % 10;
            if (res > 214748364 || (res == 214748364 && temp > 7)) {
                return 0;
            }
            if (res < -214748364 || (res == -214748364 && temp< -8)) {
                return 0;
            }
            res = res * 10 + temp;
            x /= 10;
        }
        return res;
    }
}
