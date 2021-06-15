import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Practice {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int price = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            price = Math.min(price, prices[i]);
            profit = Math.max(profit, prices[i] - profit);
        }
        return profit;
    }
}
