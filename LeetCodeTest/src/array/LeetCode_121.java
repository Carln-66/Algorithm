package array;

/**
 * @Auther: Carl
 * @Date: 2021/06/07/13:59
 * @Description: 股票
 */
public class LeetCode_121 {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {   //从第一天起开始计算
            //以下的判断只分为两种情况
            if (minPrice > prices[i]) { //时间来到了今天，如果今天的股票价格是我之前记录的所有股价的最低点，那么我就将股价最低值更新
                minPrice = prices[i];
            } else if (prices[i] - minPrice > profit) { //如果今天与我之前记录的最低股价差值最大，那么就把最大利润更新。
                profit = prices[i] - minPrice;
            }
        }
        return profit;
    }
}
