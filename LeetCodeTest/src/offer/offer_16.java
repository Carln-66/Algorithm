package offer;

/**
 * @Auther: Carl
 * @Date: 2021/06/16/20:11
 * @Description: 数值的整数次方
 */
public class offer_16 {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 1 / x * myPow(1 / x,  - n - 1);
        }
        return (n % 2) == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}
