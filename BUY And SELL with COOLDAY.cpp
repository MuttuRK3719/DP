class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        vector<vector<int>> dp(n, vector<int>(2, -1));
        return getMax(prices, 0, dp, 0);
    }
    int getMax(vector<int>& prices, int index, vector<vector<int>>& dp,
               int buy) {
        if (index >= prices.size())
            return 0;
        if (dp[index][buy] != -1)
            return dp[index][buy];
        int profit = 0;
        if (buy == 0) {
            profit = max(getMax(prices, index + 1, dp, buy),
                         -prices[index] + getMax(prices, index + 1, dp, 1));
        } else {
            profit = max(getMax(prices, index + 1, dp, buy),
                         prices[index] + getMax(prices, index + 2, dp, 0));
        }
        return dp[index][buy] = profit;
    }
};
