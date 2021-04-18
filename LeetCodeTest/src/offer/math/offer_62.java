package offer.math;

/**
 * @Auther: Carl
 * @Date: 2021/04/18/18:13
 * @Description:    #62 约瑟夫环问题
 */
public class offer_62 {
    //数学解法

    /**
     * @param n 数长
     * @param m 每隔m个取出数字
     */
    public int lastRemaining(int n, int m) {
        int res = 0;
        for (int i = 2; i < n; i++) {
            res = (res + m) % i;
        }
        return res;
    }

}
