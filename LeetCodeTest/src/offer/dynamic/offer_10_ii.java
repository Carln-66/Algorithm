package offer.dynamic;

/**
 * @Auther: Carl
 * @Date: 2021/04/13/21:43
 * @Description: #10 - ii 青蛙跳台阶
 */
public class offer_10_ii {
    public int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int pre = 1, cur = 2;
        for (int i = 3; i <= n; i++) {
            int temp = (cur + pre) % 1000000007;
            pre = cur;
            cur = temp;
        }
        return cur;
    }
}
