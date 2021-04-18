package offer.dynamic;

/**
 * @Auther: Carl
 * @Date: 2021/04/18/18:27
 * @Description:    #63 股票的最大利润
 */
public class offer_63 {
    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE;
        int profit = 0;
        for (int price : prices) {
            cost = Math.min(price, cost);
            profit = Math.max(price - cost, profit);
        }
        return profit;
    }
}
