package com.hanyuling.algorithm.dynamic;

public class BuyStock {
    public static void main(String[] args) {
        BuyStock bs = new BuyStock();
        int[] prices = {7,1,5,3,6,4};
        int m1 = bs.maxProfit(prices);
        int m2 = bs.maxProfitDynamic(prices);
        System.out.println(m1);
        System.out.println(m2);
    }


    public int maxProfit(int[] prices) {

        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i]<minPrice){
                minPrice = prices[i];
            }else if ((prices[i] - minPrice) > maxProfit){
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
    public int maxProfitDynamic(int[] prices) {

        int dp0 = 0;
        int dp1 = -prices[0];
        for (int i = 0; i < prices.length; i++) {
            dp0 = Math.max(dp0,dp1+prices[i]);
            dp1 = Math.max(dp1,-prices[i]);
        }
        return dp0;
    }
}
