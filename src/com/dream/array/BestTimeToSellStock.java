package com.dream.array;


public class BestTimeToSellStock {
    public static void main(String[] args){
        int[] prices = {1,2};
        System.out.println(maxProfit1(prices));
    }
    /**
     * 股票只能买卖一次，求可获得的最大收益
     * 思路：动态规划
     * 从前向后遍历数组，记录当前出现过的最低价格，作为买入价格，
     * 并计算以当天价格出售的收益，作为可能的最大收益，整个遍历过程中，出现过的最大收益就是所求
     */
    public static int maxProfit1(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        int len = prices.length;
        int max = 0;
        int min = prices[0];
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(prices[i],min);
            max = Math.max(max,prices[i] - min);
        }
        return max;
    }

    /**
     * 股票允许多次买卖，计算可以获取的最大收益
     * 思路：贪心法。从前向后遍历数组，只要当天的价格高于前一天的价格，就算入收益。
     */
    public static int maxProfit2(int[] prices){
        if (prices == null || prices.length < 2){
            return 0;
        }
        int proFit = 0;
        int len = prices.length;
        for (int i = 0; i < len - 1; i++) {
            if (prices[i + 1] > prices[i]){
                proFit += prices[i + 1] - prices[i];
            }
        }
        return proFit;
    }
    /*public static int maxProfit3(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
    }*/
}
