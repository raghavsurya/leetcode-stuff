class Solution {
    public int maxProfit(int[] prices) {
       
        int maxDiff = 0; int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i< prices.length; i++) {
            
            if(prices[i] < minPrice) {
                minPrice = prices[i];
            }
            
            if(prices[i] - minPrice > maxDiff) {
                maxDiff = Math.max(maxDiff, prices[i] - minPrice);
            }
            
            
            
        }
        return maxDiff;
    }
}
