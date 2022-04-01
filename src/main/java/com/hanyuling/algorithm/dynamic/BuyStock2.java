package com.hanyuling.algorithm.dynamic;

public class BuyStock2 {
    public static void main(String[] args) {
        BuyStock2 bs = new BuyStock2();
        int[] prices = {7, 1, 5, 3, 6, 4};
        int m1 = bs.maxProfit(prices);
        System.out.println(m1);
    }


    public int maxProfit(int[] prices) {
        var dp0 = 0;
        var dp1 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int ndp0 = Math.max(dp0, dp1 + prices[i]);
            int ndp1 = Math.max(dp1, dp0 - prices[i]);
            dp0 = ndp0;
            dp1 = ndp1;
        }
        return dp0;
    }

}
