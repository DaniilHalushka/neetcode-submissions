
class Solution {
    public int maxProfit(int[] prices) {
        int left = 0, maxProfit = 0;

        for (int right = 1; right < prices.length; right++) {
            if (prices[left] < prices[right]) {
                int currentProfit = prices[right] - prices[left];
                maxProfit = Math.max(maxProfit, currentProfit);
            } else {
                left = right;
            }
        }

        return maxProfit;
    }
}
