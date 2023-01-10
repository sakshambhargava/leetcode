public class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        if(prices == null || prices.length <= 1) return res;
        int[] dp = new int[prices.length];

        dp[0] = 0;
        for(int i=1; i<dp.length; i++){
            for(int j=0; j<i; j++){
                dp[i] = Math.max(prices[i]-prices[j], dp[i]);
            }
            res = Math.max(dp[i], res);
        }

        return res;
    }
}
