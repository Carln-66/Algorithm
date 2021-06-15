package dynamic;

/**
 * @Auther: Carl
 * @Date: 2021/06/15/6:51
 * @Description: 斐波那契数
 */
public class LeetCode_509 {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
}
